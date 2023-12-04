package Services_Repositories.Clases.Forms;

import DTO.SignInForm;
import Services_Repositories.Interface.Service.SignInService;
import Services_Repositories.Interface.Repositories.UserRepository;

public class SignInServiceImpl implements SignInService {
    private UserRepository userRepository;

    public   SignInServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public int checkUser(SignInForm signInForm) {
        return userRepository.findUser(signInForm.getEmail(), signInForm.getPassword());
    }
}
