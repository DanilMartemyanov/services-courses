package Services_Repositories.Interface.Service;

import Models.Admin;

import java.util.List;

public interface AdminService {
    boolean addAdmin(String email);
    boolean deleteAdmin(String email);
    List<Admin> findAdmin();


}
