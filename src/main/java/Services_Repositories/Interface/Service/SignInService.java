package Services_Repositories.Interface.Service;

import DTO.SignInForm;

public interface SignInService {
    int checkUser(SignInForm signInForm);
}
