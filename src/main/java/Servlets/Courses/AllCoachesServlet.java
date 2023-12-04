package Servlets.Courses;

import DTO.Image;
import Models.Coach;
import Services_Repositories.Interface.Service.CoachService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allCoaches")
public class AllCoachesServlet extends HttpServlet {
    CoachService coachService;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        coachService = (CoachService) servletConfig.getServletContext().getAttribute("coachService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Coach> coaches  = coachService.findCoach();
        List<Image> imagesCourses = coachService.coachImage();
        request.setAttribute("coaches" , coaches);
        request.setAttribute("imagesCoaches" ,imagesCourses);
        request.getRequestDispatcher("jsp/allCoaches.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
