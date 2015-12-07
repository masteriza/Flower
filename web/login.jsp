<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="email" value=""/>
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
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>

<body>
<div class="wrapper">

    <jsp:include page="header.jsp"/>
    <!-- .header-->

    <main class="content">

        <div class="reg-form">
            <h3 class="title">Enter the site</h3>

            <div id="registration-form">
                <div class="errorSummary">
                    <%=error%>
                </div>
                <p>
                    <label>
                        Email <span>*</span>
                    </label>

                    <input id="form_email" type="text" value="<%=email %>" name="form_email">
                </p>

                <p>
                    <label>
                        Password <span>*</span>
                    </label>
                    <input id="form_password" type="password" value="" name="form_password">
                </p>

                <p style="padding-top: 15px !important;">
                    <a href="recovery.jsp">Forgot your password?</a>
                </p>
                <br>

                <div class="btlogin_form">
                    <input type="button" value="OK">
                </div>
            </div>
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