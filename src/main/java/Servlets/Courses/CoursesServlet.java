package Servlets.Courses;

import DTO.CoursesForms;
import Models.Cours;
import Services_Repositories.Interface.Service.CoursService;
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


@WebServlet("/courses")
@MultipartConfig
public class CoursesServlet extends HttpServlet {
    CoursService coursService;
    FileService fileService;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        coursService = (CoursService) servletConfig.getServletContext().getAttribute("coursService");
        fileService = (FileService) servletConfig.getServletContext().getAttribute("fileService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cours> courses  = coursService.findCourses();
        request.setAttribute("courses" , courses);
        request.getRequestDispatcher("jsp/courses.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoursesForms coursesForms = new CoursesForms();
        coursesForms.setName(request.getParameter("nameCourses"));
        coursesForms.setCoach(request.getParameter("coach"));
        coursesForms.setDuration(request.getParameter("duration"));
        coursesForms.setDiscription(request.getParameter("discription"));
        coursesForms.setSchedule(request.getParameter("shedule"));
        coursService.saveCourses(coursesForms);

        Part part = request.getPart("file");
        fileService.saveFileCourses(
                part.getInputStream(),
                part.getSubmittedFileName(),
                part.getContentType(),
                part.getSize()
        );
        List<Cours> courses  = coursService.findCourses();
        request.setAttribute("courses" , courses);
        request.getRequestDispatcher("jsp/courses.jsp").forward(request,response);
    }
}
