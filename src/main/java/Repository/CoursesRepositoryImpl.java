package Repository;

import DTO.Image;
import DTO.UserCourses;
import Models.Cours;
import Models.FileInfo;
import Services_Repositories.Interface.Repositories.CoursRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesRepositoryImpl implements CoursRepository {
    DriverManagerDataSource dataSource;
    public CoursesRepositoryImpl(DriverManagerDataSource dataSource){
        this.dataSource = dataSource;
    }
    //language=sql
    private static final String SAVE_COURSES = "insert into courses(style, coach, duration, discription,schedule) " +
            "values (?, ?, ?, ?, ?)";

    //language=sql
    private static final String SAVE_FILE_COURSES = "insert into file_info_courses" +
            "(storage_file_name,original_file_name, type,size) " +
            "values (?, ?, ?, ?)";
    //language=sql
    private static final String FIND_COURSES= "select * from courses";
    //language=sql
    private static final String FIND_PHOTO_COURSES ="select * from file_info_courses";
    //language=sql
    private static final String ADD_USER_COURSES ="insert into courses_user(user_id,name_courses) values(?,?)";
    //language=sql
    private static final String FIND_COURSES_USER ="select * from courses_user where id = ?";
    @Override
    public boolean saveCourses(Cours courses) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_COURSES);
            preparedStatement.setString(1, courses.getStyle());
            preparedStatement.setString(2, courses.getCoach());
            preparedStatement.setString(3, courses.getDuration());
            preparedStatement.setString(4, courses.getDiscription());
            preparedStatement.setString(5, courses.getSchedule());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveFileCourses(FileInfo fileInfo) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_FILE_COURSES);
            preparedStatement.setString(1,fileInfo.getOriginalFileName());
            preparedStatement.setString(2,fileInfo.getStorageFileName());
            preparedStatement.setString(3,fileInfo.getType());
            preparedStatement.setLong(4,fileInfo.getSize());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Cours> findCourses() {
        try {
            List<Cours> courses = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_COURSES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cours cours = Cours.builder()
                        .id(resultSet.getLong("id"))
                        .style(resultSet.getString("style"))
                        .coach(resultSet.getString("coach"))
                        .duration(resultSet.getString("duration"))
                        .discription(resultSet.getString("discription"))
                        .schedule(resultSet.getString("schedule"))
                        .build();
                courses.add(cours);
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Image> coursImage() {
        try {
            List<Image> images = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PHOTO_COURSES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Image coursImage = Image.builder()
                        .originalFileName(resultSet.getString("original_file_name"))
                        .type(resultSet.getString("type"))
                        .build();
                images.add(coursImage);
            }
            return images;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUserCours(int id, String cours) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_COURSES);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,cours);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserCourses> findUserCourses(int id) {
        try {
            List<UserCourses> userCourses = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_COURSES_USER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet  = preparedStatement.executeQuery();
            while (resultSet.next()){
                UserCourses userCours = UserCourses.builder()
                        .nameCourses(resultSet.getString("name_courses"))
                        .build();
                userCourses.add(userCours);
            }
            return userCourses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
