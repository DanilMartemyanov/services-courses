package Services_Repositories.Interface.Service;

import DTO.Image;
import DTO.CoursesForms;
import DTO.UserCourses;
import Models.Cours;
import Models.FileInfo;

import java.util.List;

public interface CoursService {
    boolean saveCourses(CoursesForms coursesForms);
    void saveFileCourses(FileInfo fileInfo);
    List<Cours> findCourses();
    List<Image> coursImage();
    void addUserCours(int id , String cours);
    List<UserCourses> findUserCourses(int id);
}
