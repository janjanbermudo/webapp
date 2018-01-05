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
    <meta http-equiv="content-type" content="text/html:charset=UTF-8">
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
    ${errorMessage}
    <br>
    <br>
    <form action="/add" method="post" enctype="multipart/form-data">
        <center>
        Upload profile image:<input type="file" name="image">
        <input class="data" type="text" name="student_no" placeholder="student no" required>
        <input class="data" type="text" name="first_name" placeholder="first name" required>
        <input class="data" type="text" name="last_name" placeholder="last name" required>
        <input class="data" type="text" name="middle_name" placeholder="middle name" required>
        <input class="data" type="text" name="birthdate"  placeholder="birthdate (yyyy-mm-dd)" required>
        <input class="data" type="email" name="email" placeholder="email" required>
        <input class="data" type="text" name="contact_no" placeholder="contact number" required>
        <input class="data" type="text" name="address" placeholder="address" required>
        <input class="data" type="text" name="gender"  placeholder="gender" required>
        <input class="data" type="text" name="course" placeholder="course" required>
        <br>
        <input type="submit" name="submit" value="Register">
        </center>
    </form>
    <br>
    <center><a href="login"><button>Back</button></a></center>
</div>
<script src="plugins/js/jquery.min.js"></script>
<script src="plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
