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

    <script src="js/message.js"></script>
    <link rel="stylesheet" type="text/css" href="css/message.css"/>
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
                    <input id="UserLogin_username" class="logintext" type="text" name="UserLogin[username]">
                </p>

                <p>
                    <label class="required" for="UserLogin_password">
                        Password
                        <span class="required">*</span>
                    </label>
                    <input id="UserLogin_password" class="logintext" type="password" name="UserLogin[password]">
                </p>

                <div class="order-button">
                    <input type="button" value="OK" name="yt1">
                </div>
                <div class="link">
                    <a class="lost" href="recovery.jsp">Forgot your password?</a>
                </div>
            </form>
        </div>
    </header>
    <!-- .header-->

    <main class="content">
        <div id="message"></div>
        <br>

        <div id="centerlogo">
            <img src="img/centerlogo.png">
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