package Servlets.Courses;

import DTO.Image;
import Models.Cours;
import Services_Repositories.Interface.Service.CoursService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allCourses")
public class AllCoursesServlet extends HttpServlet {
    CoursService coursService;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        coursService = (CoursService) servletConfig.getServletContext().getAttribute("coursService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cours> courses  = coursService.findCourses();
        List<Image> imagesCourses = coursService.coursImage();
        request.setAttribute("courses" , courses);
        request.setAttribute("imagesCourses" ,imagesCourses);
        request.getRequestDispatcher("jsp/allCourses.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
