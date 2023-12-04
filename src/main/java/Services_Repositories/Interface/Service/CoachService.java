package Services_Repositories.Interface.Service;

import DTO.CoachForms;
import DTO.Image;
import Models.Coach;
import Models.FileInfo;

import java.util.List;

public interface CoachService {
    List<Coach> findCoach();
    void saveFileCoach(FileInfo fileInfo);
    boolean saveCoach(CoachForms coachForms);
    List<Image> coachImage();
}
