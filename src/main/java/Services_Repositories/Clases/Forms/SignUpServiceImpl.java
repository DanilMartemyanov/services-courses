package Services_Repositories.Clases.Forms;

import DTO.SignInForm;
import DTO.SignUpForm;
import Models.User;
import Services_Repositories.Interface.Service.SignUpService;
import Services_Repositories.Interface.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpServiceImpl implements SignUpService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean validate(SignUpForm signUpForm) {
        Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]{1,255}]");
        Matcher matcherFirstname = pattern.matcher(signUpForm.getFirstName());
        if (matcherFirstname.matches()==false){
            return false;
        }
        Matcher matcherLastname = pattern.matcher(signUpForm.getLastName());
        if (matcherLastname.matches()==false){
            return false;
        }
        return true;
    }

    @Override
    public void signUp(SignUpForm signUpForm) {
        User user = User.builder()
                .firstName(signUpForm.getFirstName())
                .lastName(signUpForm.getLastName())
                .email(signUpForm.getEmail())
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .build();

        userRepository.save(user);
    }

    @Override
    public boolean findUserByEmail(SignUpForm signUpForm) {
        return userRepository.findUserByEmail(signUpForm.getEmail());
    }


}
