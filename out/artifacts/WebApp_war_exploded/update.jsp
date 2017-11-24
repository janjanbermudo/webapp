<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<% if(session.getAttribute("username") == null) response.sendRedirect("/login.jsp"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="plugins/css/normalize.css">
    <link rel="stylesheet" href="plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="plugins/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/data.css">
</head>
<body>

<div class="container-fluid">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            Hi ${username} <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/logout">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <
    <form action="/update" method="post">
    <div class="data"><img src ="assets/images/${images}"></div>
        <input type="file" name="image">
        <input class="data" type="text" name="id" value="${id}" readonly>
        <input class="data" type="text" name="student_no" value="${student_no}" readonly>
        <input class="data" type="text" name="first_name" value="${first_name}" required>
        <input class="data" type="text" name="last_name" value="${last_name}" required>
        <input class="data" type="text" name="middle_name" value="${middle_name}" required>
        <input class="data" type="text" name="birthdate" value="${birthdate}" required>
        <input class="data" type="text" name="email" value="${email}" required>
        <input class="data" type="text" name="contact_no" value="${contact_no}" required>
        <input class="data" type="text" name="address" value="${address}" required>
        <input class="data" type="text" name="gender" value="${gender}" required>
        <input class="data" type="text" name="course" value="${course}" required>
        <center><a href="update.jsp"><button>Save</button></a></center>
        <center><a href="login.jsp"><button>Back</button></a></center>

    </form>
</div>
<script src="plugins/js/jquery.min.js"></script>
<script src="plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>