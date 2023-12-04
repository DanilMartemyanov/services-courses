package Services_Repositories.Clases.Cours;

import DTO.Image;
import DTO.CoursesForms;
import DTO.UserCourses;
import Models.Cours;
import Models.FileInfo;
import Services_Repositories.Interface.Repositories.CoursRepository;
import Services_Repositories.Interface.Service.CoursService;

import java.util.List;

public class CoursServiceImpl implements CoursService {
    CoursRepository coursRepository;
    public CoursServiceImpl(CoursRepository coursRepository){
        this.coursRepository = coursRepository;
    }
    @Override
    public boolean saveCourses(CoursesForms coursesForms) {

        Cours courses = Cours.builder()
                .style(coursesForms.getName())
                .coach(coursesForms.getCoach())
                .duration(coursesForms.getDuration())
                .discription(coursesForms.getDiscription())
                .schedule(coursesForms.getSchedule())
                .build();
        return  coursRepository.saveCourses(courses);
    }

    @Override
    public void saveFileCourses(FileInfo fileInfo) {
        coursRepository.saveFileCourses(fileInfo);
    }

    @Override
    public List<Cours> findCourses() {
        return coursRepository.findCourses();
    }

    @Override
    public List<Image> coursImage() {
        return coursRepository.coursImage();
    }

    @Override
    public void addUserCours(int id, String cours) {
        coursRepository.addUserCours(id, cours);
    }

    @Override
    public List<UserCourses> findUserCourses(int id) {
        return coursRepository.findUserCourses(id);
    }
}
