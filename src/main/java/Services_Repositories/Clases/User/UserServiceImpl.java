package Services_Repositories.Clases.User;

import DTO.SignInForm;
import Repository.UserRepositoryImpl;
import Services_Repositories.Interface.Repositories.UserRepository;
import Services_Repositories.Interface.Service.UserService;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public int getRole(SignInForm signInForm) {
        return userRepository.getRoleByEmail(signInForm.getEmail());

    }
}
