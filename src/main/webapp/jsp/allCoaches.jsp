<%@ page import="Models.Coach" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.Image" %><%--
  Created by IntelliJ IDEA.
  User: danilmartemianov
  Date: 29.11.2023
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тренера</title>
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
<h1>Тренера</h1>
<% List<Coach> coaches = (List<Coach>) request.getAttribute("coaches");
    List<Image> imagesCourses = (List<Image>) request.getAttribute("imagesCoaches");
    int countImage = 0;
    for(Coach coach : coaches){
%>
    <div class="card" style="width: 18rem;">
        <%String path0 = "files/coaches/" + imagesCourses.get(countImage).getOriginalFileName() + "." + imagesCourses.get(countImage).getType().split("/")[1];%>
        <img src="<%=path0%>" class="card-img-top">
        <div class="card-body">
            <h5 class="card-title">NickName: <%=coach.getFirstName()%></h5>
            <p class="card-text"></p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Expirience: <%=coach.getExperience()%></li>
            <li class="list-group-item">Style: <%=coach.getStyle()%></li>
        </ul>
    </div>
    <%countImage++;%>
    <%}%>
</div>
</body>
</html>
