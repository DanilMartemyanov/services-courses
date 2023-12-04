package Servlets.Courses;

import DTO.UserCourses;
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

@WebServlet("/yourCourses")
public class UserCourseServlet extends HttpServlet {
    CoursService coursService;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        coursService = (CoursService) servletConfig.getServletContext().getAttribute("coursService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id  = (int) session.getAttribute("id");
        List<UserCourses> userCourses = coursService.findUserCourses(id);
        request.setAttribute("userCourses",userCourses);
        request.getRequestDispatcher("jsp/userCourses.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
