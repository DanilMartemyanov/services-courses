package Services_Repositories.Interface.Repositories;

import DTO.Image;
import DTO.UserCourses;
import Models.Cours;
import Models.FileInfo;

import java.util.List;

public interface CoursRepository {
    boolean saveCourses(Cours courses);
    void saveFileCourses(FileInfo fileInfo);
    List<Cours> findCourses();
    List<Image> coursImage();
    void addUserCours(int id , String cours);
    List<UserCourses> findUserCourses(int id);

}
