package Listener;


import Repository.AdminRepositoriesImpl;
import Repository.CoachRepositoryImpl;
import Repository.CoursesRepositoryImpl;
import Services_Repositories.Clases.Admin.AdminServiceImpl;
import Services_Repositories.Clases.Coach.CoachServiceImpl;
import Services_Repositories.Clases.Cours.CoursServiceImpl;
import Services_Repositories.File.FileServiceImpl;
import Services_Repositories.Clases.Forms.SignInServiceImpl;
import Services_Repositories.Clases.Forms.SignUpServiceImpl;
import Repository.UserRepositoryImpl;
import Services_Repositories.Clases.User.UserServiceImpl;
import Services_Repositories.Interface.Repositories.AdminRepository;
import Services_Repositories.Interface.Repositories.CoachRepository;
import Services_Repositories.Interface.Repositories.CoursRepository;
import Services_Repositories.Interface.Repositories.UserRepository;
import Services_Repositories.Interface.Service.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitServletContext implements ServletContextListener {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String USER = "siteCourse";
    private static final String URL = "jdbc:postgresql://localhost:5434/siteCourses";
    private static final String PASSWORD = "siteCourse";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        ServletContext servletContext = servletContextEvent.getServletContext();

        UserRepository userRepository = new UserRepositoryImpl(dataSource);
        servletContext.setAttribute("userRepository", userRepository);

        SignUpService signUpService = new SignUpServiceImpl(userRepository);
        servletContext.setAttribute("signUpService", signUpService);

        SignInService signInService = new SignInServiceImpl(userRepository);
        servletContext.setAttribute("signInService", signInService);

        AdminRepository adminRepository = new AdminRepositoriesImpl(dataSource);
        servletContext.setAttribute("adminRepository", adminRepository);

        AdminService adminService = new AdminServiceImpl(adminRepository);
        servletContext.setAttribute("adminService", adminService);

        CoursRepository coursRepository = new CoursesRepositoryImpl(dataSource);
        servletContext.setAttribute("coursRepository", coursRepository);

        CoachRepository coachRepository = new CoachRepositoryImpl(dataSource);
        servletContext.setAttribute("coachRepository",coachRepository );

        FileService fileService = new FileServiceImpl(coursRepository, coachRepository);
        servletContext.setAttribute("fileService", fileService);

        CoursService coursService = new CoursServiceImpl(coursRepository);
        servletContext.setAttribute("coursService" , coursService);

        CoachService coachService= new CoachServiceImpl(coachRepository);
        servletContext.setAttribute("coachService", coachService);

        UserService userService  =new UserServiceImpl(userRepository);
        servletContext.setAttribute("userService",userService);


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
