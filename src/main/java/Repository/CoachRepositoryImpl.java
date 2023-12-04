package Repository;

import DTO.Image;
import Models.Coach;
import Models.FileInfo;
import Services_Repositories.Interface.Repositories.CoachRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachRepositoryImpl implements CoachRepository {
    DriverManagerDataSource dataSource;
    public CoachRepositoryImpl(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }
    //language=sql
    private static final String SAVE_FILE_COACH = "insert into file_info_coach" +
            "(storage_file_name,original_file_name, type,size) " +
            "values (?, ?, ?, ?)";
    //language=sql
    private static final String FIND_COACHES= "select * from coaches";

    //language=sql
    private static final String SAVE_COACH = "insert into coaches(firstname, lastname, experience, style) " +
            "values (?, ?, ?, ?)";
    //language=sql
    private static final String FIND_PHOTO_COURSES ="select * from file_info_coach";
    @Override
    public void saveFileCoach(FileInfo fileInfo) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_FILE_COACH);
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
    public List<Coach> findCoach() {
        try {
            List<Coach> coaches = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_COACHES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Coach coach = Coach.builder()
                        .id(resultSet.getLong("id"))
                        .firstName(resultSet.getString("firstName"))
                        .lastName(resultSet.getString("lastName"))
                        .experience(resultSet.getString("experience"))
                        .style(resultSet.getString("style"))
                        .build();
                coaches.add(coach);
            }
            return coaches;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean saveCoach(Coach coach) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_COACH);
            preparedStatement.setString(1, coach.getFirstName());
            preparedStatement.setString(2, coach.getLastName());
            preparedStatement.setString(3, coach.getExperience());
            preparedStatement.setString(4, coach.getStyle());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Image> coachImage() {
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

}
