package Servlets.Courses;

import DTO.CoachForms;
import Models.Admin;
import Models.Coach;
import Services_Repositories.Interface.Service.AdminService;
import Services_Repositories.Interface.Service.CoachService;
import Services_Repositories.Interface.Service.FileService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/coaches")
@MultipartConfig
public class CoachServlet extends HttpServlet {
    CoachService coachService;
    FileService fileService;
    AdminService adminService;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        adminService = (AdminService) servletConfig.getServletContext().getAttribute("adminService");
        coachService= (CoachService) servletConfig.getServletContext().getAttribute("coachService");
        fileService = (FileService) servletConfig.getServletContext().getAttribute("fileService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Coach> coaches = coachService.findCoach();
        request.setAttribute("coaches" , coaches);
        request.getRequestDispatcher("jsp/coaches.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoachForms coachForms = new CoachForms();
        System.out.println(request.getParameter("firstName"));
        coachForms.setFirstName(request.getParameter("firstName"));
        coachForms.setLastName(request.getParameter("lastName"));
        coachForms.setExperience(request.getParameter("experience"));
        coachForms.setStyle(request.getParameter("style"));
        Part part = request.getPart("file");
        fileService.saveFileCoach(
                part.getInputStream(),
                part.getSubmittedFileName(),
                part.getContentType(),
                part.getSize()
        );
        if (coachService.saveCoach(coachForms)){
            List<Admin> admins = adminService.findAdmin();
            request.setAttribute("admins" , admins);
            request.getRequestDispatcher("jsp/adminPanel.jsp").forward(request,response);
        }

    }
}
