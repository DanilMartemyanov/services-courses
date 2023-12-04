package Servlets.Courses;

import DTO.Image;
import DTO.UserCourses;
import Models.Cours;
import Services_Repositories.Interface.Repositories.CoursRepository;
import Services_Repositories.Interface.Service.AdminService;
import Services_Repositories.Interface.Service.CoursService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/record-courses")
public class RecordCourses extends HttpServlet {
    CoursRepository coursRepository;
    AdminService adminService;
    CoursService coursService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        coursRepository = (CoursRepository) servletConfig.getServletContext().getAttribute("coursRepository");
        adminService = (AdminService) servletConfig.getServletContext().getAttribute("adminService");
        coursService = (CoursService) servletConfig.getServletContext().getAttribute("coursService");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cours> courses  = coursService.findCourses();
        request.setAttribute("courses" , courses);
        request.getRequestDispatcher("jsp/record.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cours = request.getParameter("dance");
        HttpSession session = request.getSession(true);
       try{
           int idUser = (int) session.getAttribute("id");
           coursService.addUserCours(idUser,cours);
           List<UserCourses> userCourses = coursService.findUserCourses(idUser);
           request.setAttribute("userCourses",userCourses);
           request.getRequestDispatcher("jsp/userCourses.jsp").forward(request,response);
       }catch (Exception e){
           response.sendRedirect("/html/forms/signIn");
       }

    }
}
