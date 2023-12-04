package Services_Repositories.Interface.Repositories;

import Models.Admin;

import java.util.List;

public interface AdminRepository {
    boolean addAdmin(String email);
    String findIdByEmail(String email);
    boolean deleteAdmin(String emil);
    List<Admin> findAdmin();

}
