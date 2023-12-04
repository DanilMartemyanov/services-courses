package Services_Repositories.Interface.Service;

import DTO.SignInForm;
import DTO.SignUpForm;

public interface SignUpService {

    boolean validate(SignUpForm signUpForm);
    void signUp(SignUpForm signUpForm);
    boolean findUserByEmail(SignUpForm signUpForm);
}
