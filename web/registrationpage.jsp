<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="plugins/css/normalize.css">
    <link rel="stylesheet" href="plugins/bootstra   p-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="plugins/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/loginpage.css">
</head>
<body>
            ${errorMessage}

                <main class="main">
                    <form method="post" action="/registrationpage" >
                    <div class="login-box">

                        <h2>Sign Up</h2>
                        <input type="username" placeholder="Username"/>
                        <input type="password" placeholder="Password"/>
                        <input type="password" placeholder="Retype-Password"/>
                        <input type="email" placeholder="Email"/>
                        <input type="text" placeholder="Birthdate(yyyy-mm-dd)"/>
                        <input type="text" placeholder="Cellphone number(+63)"/>
                        <div class="btns">
                            <button class="signup-btn">Sign Up</button></div>

                    </div>
                    </form>
                </main>

                    <a href="/cancel"><button class="signup-btn">Back</button></a>
<script src="plugins/js/jquery.min.js"></script>
<script src="plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
