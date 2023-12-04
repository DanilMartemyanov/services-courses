package Filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StringContent;
import java.io.IOException;


@WebFilter("/*")
public class AuthFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
//        String context = request.getContextPath();
//        System.out.println(context);


        Boolean isAuthorization = (Boolean) session.getAttribute("authorization");
        Boolean yourCourses = request.getRequestURI().equals("/SiteCourses_war/yourCourses");
        Boolean recordCourses = request.getRequestURI().equals("/SiteCourses_war/record-courses");


        if (isAuthorization == null) {
            isAuthorization = false;
        }
        if (!isAuthorization && yourCourses) {
            response.sendRedirect("/SiteCourses_war/signIn");
        } else if (!isAuthorization && recordCourses) {
            response.sendRedirect("/SiteCourses_war/signIn");
        } else {
            filterChain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {
    }
}
