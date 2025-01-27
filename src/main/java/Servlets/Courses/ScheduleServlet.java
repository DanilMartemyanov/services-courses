package Servlets.Courses;

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

@WebServlet("/schedule")
public class ScheduleServlet extends HttpServlet {
    CoursService coursService;

    public void init(ServletConfig servletConfig) throws ServletException {
        coursService = (CoursService) servletConfig.getServletContext().getAttribute("coursService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cours> courses  = coursService.findCourses();
        request.setAttribute("courses" , courses);
        request.getRequestDispatcher("jsp/schedule.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
