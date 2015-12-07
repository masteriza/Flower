<%
    String email = (String) session.getAttribute("email");
    if (email == null) {
        email = "";
    }
    String error = (String) session.getAttribute("error");
    if (error == null) {
        error = "";
    }
%>
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

    <script src="js/index.js"></script>
    <link rel="stylesheet" type="text/css" href="css/recovery.css"/>
</head>

<body>

<div class="wrapper">

    <jsp:include page="header.jsp"/>
    <!-- .header-->

    <main class="content">
        <div class="registration">
            <div class="reg-form">
                <h3 class="title">Enter your email</h3>

                <div class="errorSummary">
                    <%=error%>
                </div>
                <div>
                    <p>
                        <label>Email</label>
                        <input id="recovery_email" type="text">
                    </p>

                    <p class="hint">Please, enter your email address.</p>

                    <p></p>

                    <div class="btRecovery">
                        <input type="button" value="Recovery">
                    </div>
                    <br>
                </div>
            </div>
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