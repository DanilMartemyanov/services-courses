package Services_Repositories.Interface.Service;

import DTO.SignInForm;

public interface UserService {
    int getRole(SignInForm signInForm);
}
