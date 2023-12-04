package Services_Repositories.Interface.Repositories;

import DTO.SignUpForm;
import Models.User;

public interface UserRepository {
    void save(User user);

    int findUser(String email , String password);
    boolean findUserByEmail(String email);
    int getRoleByEmail(String email);
}
