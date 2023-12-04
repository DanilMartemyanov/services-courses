package Services_Repositories.Clases.Admin;

import Models.Admin;
import Services_Repositories.Interface.Repositories.AdminRepository;
import Services_Repositories.Interface.Service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @Override
    public boolean addAdmin(String email) {
       return adminRepository.addAdmin(email);
    }

    @Override
    public boolean deleteAdmin(String email) {
        return adminRepository.deleteAdmin(email);
    }

    @Override
    public List<Admin> findAdmin() {
        return adminRepository.findAdmin();
    }


}
