package Servlets.Froms;

import DTO.SignInForm;
import Services_Repositories.Interface.Service.AdminService;
import Services_Repositories.Interface.Service.SignInService;
import Services_Repositories.Interface.Repositories.UserRepository;
import Services_Repositories.Interface.Service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private SignInService singInService;
    private UserRepository userRepository;
    private UserService userService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        userService = (UserService) servletConfig.getServletContext().getAttribute("userService") ;
        userRepository = (UserRepository) servletConfig.getServletContext().getAttribute("userRepository");
        singInService = (SignInService) servletConfig.getServletContext().getAttribute("signInService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/forms/signIn.html").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        SignInForm signInForm = new SignInForm();
        signInForm.setEmail(email);
        signInForm.setPassword(password);

        int id = singInService.checkUser(signInForm);
        int role = userService.getRole(signInForm);
         if (id!=0){
             HttpSession session = request.getSession(true);
             session.setAttribute("authorization" , true);
             session.setMaxInactiveInterval(60*3600);
             session.setAttribute("email", email);
             session.setAttribute("id" , id);
             session.setAttribute("role" , role);
             request.getRequestDispatcher("jsp/indexUser.jsp").forward(request,response);
         }else{
             response.sendRedirect("html/forms/signIn.html");

         }
    }
}
