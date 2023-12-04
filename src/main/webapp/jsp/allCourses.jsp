<%@ page import="Models.Cours" %>
<%@ page import="java.util.List" %>
<%@ page import="DTO.Image" %>
<%@ page import="Models.Coach" %><%--
  Created by IntelliJ IDEA.
  User: danilmartemianov
  Date: 29.11.2023
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Курсы</title>
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
<h1>Курсы</h1>
<% List<Cours> courses = (List<Cours>) request.getAttribute("courses");
   List<Image> imagesCourses = (List<Image>) request.getAttribute("imagesCourses");
   int countImage = 0;
   for(Cours cours: courses){
%>
    <%String path = "files/courses/" + imagesCourses.get(countImage).getOriginalFileName() + "." + imagesCourses.get(countImage).getType().split("/")[1];%>
    <img src="<%=path%>">
<div>
    <div class="card text-bg-dark mb-3" style="max-width: 18rem;">
        <div class="card-header"><%=cours.getStyle()%></div>
        <div class="card-body">
            <h5 class="card-title">Info</h5>
            <p class="card-text"><%=cours.getDiscription()%></p>
        </div>
        <%countImage++;%>
        <%};%>
    </div>
</div>

    <%--<div>--%>
    <%--    <h2><%=cours.getStyle()%></h2>--%>
    <%--    <%String path0 = "files/courses/" + imagesCourses.get(countImage).getOriginalFileName() + "." + imagesCourses.get(countImage).getType().split("/")[1];%>--%>
    <%--    <img src="<%=path0%>">--%>
    <%--    <h3>Тренер</h3>--%>
    <%--    <h4><%=cours.getCoach()%></h4>--%>
    <%--    <h3>Продолжительность</h3>--%>
    <%--    <h4><%=cours.getDuration()%></h4>--%>
    <%--    <h3>Описание</h3>--%>
    <%--    <h4><%=cours.getDiscription()%></h4>--%>
    <%--</div>--%>
</body>
</html>
