<#import "/spring.ftl" as spring/>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Css Styles -->
    <link rel="stylesheet" href="<@spring.url 'resources/css/style.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/font-awesome.min.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/elegant-icons.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/nice-select.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/jquery-ui.min.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/owl.carousel.min.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/slicknav.min.css'/>"/>

    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;

        }

        * {
            box-sizing: border-box;
        }

        .container {
            padding: 16px;
            background-color: white;
        }

        input[type=text], input[type=password] {
            width: 30%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        .registerbtn {
            background-color: #523c86;
            color: white;
            padding: 16px 200px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 30%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        a {
            color: dodgerblue;
        }

        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link rel="stylesheet" th:href="@{/webjars/bootstrap/4.1.0/css/bootstrap.min.css}" />
    <script th:src="@{/webjars/bootstrap/4.1.0/js/bootstrap.min.js}"></script>
</head>
<body>

<div class="container">
    <form action="/login/authorize" method="get">
        <div class="container">
            <h1>Login Page</h1>
            <p>Fill all blanks</p>
            <hr>
            <label><b>Login</b></label><br>
            <input type="text" placeholder="Username" id="username" name="userName" required> ${message?if_exists}<br>

            <label><b>Password</b></label><br>
            <input type="password" placeholder="Password" id="password" name="password" required><br>
            <button style="background-color: #7fad39 "  type="submit" class="registerbtn" href="/index">Login</button> <br>
        </div>

    </form>
    <div class="container signin">
        <p>Dont have account?  <a href="/register">Register here</a>.</p>
    </div>
</div>
</body>
</html>