package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/admin", "/courses", "/coaches" })
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        try {
            int role = (int)session.getAttribute("role");
            if(role==1 && (int)session.getAttribute("id")!=0){
                filterChain.doFilter(request,response);
            }else if (role==0 && (int)session.getAttribute("id")!=0){
                response.sendRedirect("/SiteCourses_war/allCourses");
            }else{
                response.sendRedirect("/SiteCourses_war/signUp");
            }
        } catch (Exception e){
            response.sendRedirect("/SiteCourses_war/signIn");
        }

    }

    @Override
    public void destroy() {

    }
}
