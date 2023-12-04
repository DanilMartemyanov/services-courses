package Services_Repositories.Clases.Coach;

import DTO.CoachForms;
import DTO.Image;
import Models.Coach;
import Models.FileInfo;
import Services_Repositories.Interface.Repositories.CoachRepository;
import Services_Repositories.Interface.Service.CoachService;

import java.util.List;

public class CoachServiceImpl  implements CoachService {
    CoachRepository coachRepository;
    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository= coachRepository;
    }

    @Override
    public List<Coach> findCoach() {
        return coachRepository.findCoach();
    }

    @Override
    public void saveFileCoach(FileInfo fileInfo) {
        coachRepository.saveFileCoach(fileInfo);
    }

    @Override
    public boolean saveCoach(CoachForms coachForms) {
        Coach coach = Coach.builder()
                .firstName(coachForms.getFirstName())
                .lastName(coachForms.getLastName())
                .experience(coachForms.getExperience())
                .style(coachForms.getStyle())
                .build();
        return coachRepository.saveCoach(coach);
    }

    @Override
    public List<Image> coachImage() {
        return coachRepository.coachImage();
    }
}
