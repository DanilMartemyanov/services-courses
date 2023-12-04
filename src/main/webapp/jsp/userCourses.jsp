<%@ page import="DTO.UserCourses" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: danilmartemianov
  Date: 02.12.2023
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/SiteCourses_war/allCourses">allCourses</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/SiteCourses_war/record-courses">Registration for courses </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/SiteCourses_war/allCoaches">allCoaches</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/SiteCourses_war/signUp">SignUp</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/SiteCourses_war/signIn">SignIn</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/SiteCourses_war/schedule">shedule</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/SiteCourses_war/yourCourses">YourCourses</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <h2>Ваши курсы</h2>
    <table class="table">
        <tr>
            <th>CoursName</th>
                <%List<UserCourses> courses = (List<UserCourses>) request.getAttribute("userCourses");
            for(UserCourses cours : courses){
            %>
        <tr>
            <td><%= cours.getNameCourses()%></td>
        </tr>
        <%};%>
    </table>
</div>
</body>
</html>