<%--
  Created by IntelliJ IDEA.
  User: danilmartemianov
  Date: 15.11.2023
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
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
                    <a class="nav-link" href="/SiteCourses_war/schedule">shedule</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/SiteCourses_war/yourCourses">YourCourses</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>
