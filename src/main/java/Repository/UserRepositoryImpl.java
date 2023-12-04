package Repository;

import DTO.SignUpForm;
import Models.User;
import Services_Repositories.Interface.Repositories.UserRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl  implements UserRepository {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private DataSource dataSource ;
    //language=sql
    private static  final String ADD_USER = "insert into users (firstname, lastname, email, password)" +
            "values (?, ?, ?, ?);";

    //language=sql
    private static final String FIND_USER = "select id , email , password from users;";
    //language=sql
    private static final String FIND_USERBYEMAIL = "select  email from users;";
    //language=sql
    private static final String ROLE = "select role from users where email= ?;";

    public UserRepositoryImpl(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(User user) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
            preparedStatement.setString(1 , user.getFirstName());
            preparedStatement.setString(2 , user.getLastName());
            preparedStatement.setString(3 , user.getEmail());
            preparedStatement.setString(4 , user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findUser(String email, String password) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                if (resultSet.getString("email").equals(email)){
                    if (passwordEncoder.matches(password , resultSet.getString("password"))){
                        return resultSet.getInt("id");
                    }else {
                        return 0;
                    }
                }else {
                    System.out.println("некорректная почта");
                }
            }
             return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean findUserByEmail(String email) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERBYEMAIL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("email").equals(email)){
                    return true;
                }else {
                    System.out.println("некорректная почта");
                }
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getRoleByEmail(String email) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ROLE);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("role");
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }
}
