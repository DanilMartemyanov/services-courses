package Servlets.Froms;

import DTO.SignUpForm;
import Services_Repositories.Interface.Service.SignUpService;
import Services_Repositories.Interface.Repositories.UserRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private SignUpService signUpService;
    private UserRepository userRepository;



    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        userRepository = (UserRepository) servletConfig.getServletContext().getAttribute("userRepository");
        signUpService = (SignUpService) servletConfig.getServletContext().getAttribute("signUpService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/forms/signUp.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setFirstName(request.getParameter("firstName"));
        signUpForm.setLastName(request.getParameter("lastName"));
        signUpForm.setEmail(request.getParameter("email"));
        signUpForm.setPassword(request.getParameter("password"));
        if(signUpService.findUserByEmail(signUpForm)){
            request.getRequestDispatcher("html/exception.html").forward(request,response);
        }else{
            signUpService.signUp(signUpForm);
            request.getRequestDispatcher("jsp/indexUser.jsp").forward(request,response);

        }
    }
}
