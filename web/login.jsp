<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>

    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

    <script src="js/login.js"></script>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>

<body>

<div class="wrapper">

    <header class="header">
        <div id="logo">
            <a href="index.jsp"><img src="img/flower_logo.png"></a>
        </div>
        <div id="logotext">Flower - advance internet provider</div>
        <div id="menu">
            <ul>
                <li id="register">
                    <a href="registration.jsp">Sign up</a>
                </li>
                <li id="login">
                    <a href="#login">Log In</a>
                </li>
            </ul>
        </div>

        <div class="login-form" style="display: none;">
            <h3>Enter the site</h3>

            <form id="user-form" method="post" action="/user/login">
                <p>
                    <label class="required" for="UserLogin_username">
                        Email
                        <span class="required">*</span>
                    </label>
                    <input id="email" class="logintext" type="text" name="email">
                </p>

                <p>
                    <label class="required">
                        Password
                        <span class="required">*</span>
                    </label>
                    <input id="password" class="logintext" type="password" name="password">
                </p>

                <div class="order-button">
                    <input type="submit" value="OK" name="yt1">
                </div>
                <div class="link">
                    <a class="lost" href="recovery.jsp">Forgot your password?</a>
                </div>
            </form>
        </div>
    </header>
    <!-- .header-->

    <main class="content">

        <div class="reg-form">
            <h1 class="title">Вход</h1>

            <form id="registration-form" method="post" action="/user/login" enctype="multipart/form-data">
                <div class="errorSummary">

                    <ul>
                        <li>Incorrect login or password.</li>
                    </ul>
                </div>
                <p>
                    <label class="error required" for="UserLogin_username">
                        email
                        <span class="required">*</span>
                    </label>
                    <input id="UserLogin_username" class="error" type="text" value=""
                           name="UserLogin[username]">
                </p>

                <p>
                    <label class="required" for="UserLogin_password">
                        Пароль
                        <span class="required">*</span>
                    </label>
                    <input id="UserLogin_password" type="password" value="" name="UserLogin[password]">
                </p>

                <p style="padding-top: 15px !important;">
                    <a href="recovery.jsp">Forgot your password?</a>
                </p>
                <br>

                <div class="row-button">
                    <input type="submit" value="Вход" name="yt0">
                    <a class="reg" href="registration.jsp">Sign up</a>
                </div>
            </form>
            <br>
        </div>


    </main>
    <!-- .content -->

</div>
<!-- .wrapper -->

<footer class="footer">
    Design and Development by Viacheslav Chernyshov
</footer>
<!-- .footer -->

<div id="overlay" class="overlay" style="display:none;"></div>
</body>
</html>