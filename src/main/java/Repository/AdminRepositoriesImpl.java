package Repository;

import Models.Admin;
import Services_Repositories.Interface.Repositories.AdminRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoriesImpl implements AdminRepository {

    private DataSource dataSource;

    public AdminRepositoriesImpl(DriverManagerDataSource dataSource){
        this.dataSource = dataSource;
    }

    //language=sql
    private final String ADD_ADMIN = "update users set role = 1 where email = ?";

    //language=sql
    private final String FIND_EMAIL = "select email from users";
    //language=sql
    private final String DELETE_ADMIN = "update users set role = 0 where email = ?";

    //language=sql
    private static  final String FIND_ADMIN = "select id ,firstName, email from users where role = 1";
    @Override
    public boolean addAdmin(String email) {
        try {
            if(findIdByEmail(email)==null) return false;
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ADMIN);
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String findIdByEmail(String email) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMAIL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("email").equals(email)){
                    return resultSet.getString("email");
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteAdmin(String email) {
        try {
            if(findIdByEmail(email)==null) return false;
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADMIN);
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Admin> findAdmin() {
        try {
            List<Admin> admins = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ADMIN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Admin admin = Admin.builder()
                        .id(resultSet.getLong("id"))
                        .firstName(resultSet.getString("firstname"))
                        .email(resultSet.getString("email"))
                        .build();
                admins.add(admin);
            }
            return admins;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
