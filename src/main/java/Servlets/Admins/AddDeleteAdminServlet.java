package Servlets.Admins;

import Models.Admin;
import Services_Repositories.Interface.Repositories.AdminRepository;
import Services_Repositories.Interface.Repositories.UserRepository;
import Services_Repositories.Interface.Service.AdminService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/admin")
public class AddDeleteAdminServlet extends HttpServlet {
    AdminRepository adminRepository;
    AdminService adminService;
    UserRepository userRepository;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        adminRepository = (AdminRepository) servletConfig.getServletContext().getAttribute("adminRepository");
        adminService = (AdminService) servletConfig.getServletContext().getAttribute("adminService");
        userRepository = (UserRepository) servletConfig.getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        session1.setMaxInactiveInterval(60*3600);
        String emailSession = (String) session1.getAttribute("email");
        if(userRepository.getRoleByEmail(emailSession)==-1){
            response.sendRedirect("jsp/allCourses.jsp");
        }
        List<Admin> admins = adminService.findAdmin();
        request.setAttribute("admins" , admins);
        request.getRequestDispatcher("jsp/adminPanel.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String command  = request.getParameter("command");
        System.out.println(command);
        if (command.equals("add")){
            if (adminService.addAdmin(email)){
                List<Admin> admins = adminService.findAdmin();
                request.setAttribute("admins" , admins);
                request.getRequestDispatcher("jsp/adminPanel.jsp").forward(request,response);
            }else {
                response.sendRedirect("jsp/adminPanel.jsp");
            }
        }
        if (command.equals("delete")){
            if (adminService.deleteAdmin(email)){
                List<Admin> admins = adminService.findAdmin();
                request.setAttribute("admins" , admins);
                request.getRequestDispatcher("jsp/adminPanel.jsp").forward(request,response);
            }else{
                response.sendRedirect("jsp/adminPanel.jsp");
            }
        }
    }
}
