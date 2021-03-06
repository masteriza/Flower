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
<header class="header">
    <div id="logo">
        <a href="index.jsp"><img src="img/flower_logo.png"></a>
    </div>
    <div id="logotext">Flower - advance internet provider</div>
    <div id="menu">
        <ul>
            <li id="pgRegistration">
                <a href="#">Sign up</a>
            </li>
            <li id="login">
                <a href="#">Log In</a>
            </li>
        </ul>
    </div>

    <div class="login-form" style="display: none;">
        <h3>Enter the site</h3>

        <div id="user-form">
            <p><label> Email <span>*</span> </label>
                <input id="email" class="logintext" type="text" name="email" value="<%=email%>">
            </p>

            <p><label> Password <span>*</span> </label>
                <input id="password" class="logintext" type="password" name="password">
            </p>

            <div id="btlogin">
                <input type="button" value="OK">
            </div>
            <div class="link">
                <a class="lost" href="recovery.jsp">Forgot your password?</a>
            </div>
        </div>
    </div>
</header>
