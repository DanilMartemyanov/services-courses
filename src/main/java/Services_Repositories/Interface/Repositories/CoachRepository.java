package Services_Repositories.Interface.Repositories;

import DTO.Image;
import Models.Coach;
import Models.FileInfo;

import java.util.List;

public interface CoachRepository {
    void saveFileCoach(FileInfo fileInfo);
    List<Coach> findCoach();
    boolean saveCoach(Coach coach);
    List<Image> coachImage();
}
