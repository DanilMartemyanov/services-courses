<%@ page import="java.util.List" %>
<%@ page import="Models.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админ панель</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
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
                        <a class="nav-link" href="/SiteCourses_war/schedule">Shedule</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/SiteCourses_war/yourCourses">YourCourses</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
<form action="/SiteCourses_war/admin" method="post">
    <div>
        <h1>Действия с админом</h1>
        <label for="nameCourses" class="form-label">Введите email пользователя</label>
        <input type="email" name="email" placeholder="Enter email" class="form-control">
        <fieldset>
            <div>
                <input class="form-check-input" type="radio" value="add"  id="add" name="command">
                <label  class="form-check-label" for="add">Добавить</label>
            </div>
            <div>
                <input class="form-check-input" type="radio" value="delete" id="delete" name="command">
                <label class="form-check-label" for="delete">Удалить</label>
            </div>
            <button type="submit">Выполнить</button>
        </fieldset>
    </div>
</form>
<div>
    <h2>Таблица админов</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>firstName</th>
            <th>email</th>
        <% List<Admin> admins = (List<Admin>) request.getAttribute("admins");
            for(Admin admin : admins){
        %>
        <tr>
        <td><%= admin.getId()%></td>
        <td><%= admin.getFirstName()%></td>
        <td><%= admin.getEmail()%></td>
        </tr>
            <%}

        %>
    </table>
</div>
<div>
    <form action="/SiteCourses_war/courses" method="post" enctype="multipart/form-data">
        <h2>Регистрация курса на сайте</h2>
        <br>
        <label for="nameCourses" class="form-label">Name Courses</label>
        <input type="text" name="nameCourses" id="nameCourses" class="form-control">
        <br>
        <label for="coach" class="form-label">Coach</label>
        <input type="text" name="coach" id="coach" class="form-control">
        <br>
        <label for="duration" class="form-label">Duration</label>
        <input type="text" name="duration" id="duration" class="form-control">
        <br>
        <label for="discription" class="form-label">Discription</label>
        <input type="text" name="discription" id="discription" class="form-control">
        <br>
        <label for="shedule" class="form-label">Shedule</label>
        <input type="text" name="shedule" id="shedule" class="form-control">
        <br>
        <label class="form-label">Image</label>
        <input type="file" name="file" class="form-control">
        <button type="submit"> Отправить</button>
    </form>
</div>
<div>
    <form action="/SiteCourses_war/coaches" method="post" enctype="multipart/form-data">
        <h2>Регистрация тренера на сайте</h2>
        <br>
        <label for="firstName" class="form-label">FirstName</label>
        <input type="text" name="firstName" id="firstName" class="form-control">
        <br>
        <label for="lastName" class="form-label">LasttName</label>
        <input type="text" name="lastName" id="lastName" class="form-control">
        <br>
        <label for="experience" class="form-label">Experience</label>
        <input type="text" name="experience" id="experience" class="form-control">
        <br>
        <label for="style" class="form-label">Style</label>
        <input type="text" name="style" id="style" class="form-control">
        <br>
        <label class="form-label">Image</label>
        <input  class="form-control" type="file" name="file">
        <button type="submit"> Отправить</button>
    </form>
</div>
</div>
</body>
</html>
