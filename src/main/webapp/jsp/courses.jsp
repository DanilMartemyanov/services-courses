<%@ page import="Models.Cours" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: danilmartemianov
  Date: 24.11.2023
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kурсы</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/SiteCourses_war/admin">Admin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/SiteCourses_war/coaches">Coaches</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/SiteCourses_war/courses">Courses</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/SiteCourses_war/signIn">SignIn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/SiteCourses_war/signUp"  >SignUp</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/SiteCourses_war/record-courses">Registration for courses </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/SiteCourses_war/allCoaches">allCoaches</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/SiteCourses_war/allCourses">allCourses</a>
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
<div class="container">
    <h2>Таблица курсов</h2>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>NameCourses</th>
            <th>Coach</th>
                <% List<Cours> courses = (List<Cours>) request.getAttribute("courses");
            for(Cours cours : courses){
        %>
        <tr>
            <td><%= cours.getId()%></td>
            <td><%= cours.getStyle()%></td>
            <td><%= cours.getCoach()%></td>
        </tr>
        <%}
        %>
    </table>
</div>
</body>
</html>
