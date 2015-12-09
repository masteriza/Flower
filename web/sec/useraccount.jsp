<%@page contentType="text/html" pageEncoding="UTF-8" import="com.flower.dao.*" %>
<%@ page import="com.flower.Service" %>
<%@ page import="com.flower.User" %>
<jsp:useBean class="com.flower.dao.DAO" id="DAO" scope="application"/>

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
    <script src="http://maps.google.com/maps/api/js?sensor=false&libraries=geometry"></script>

    <script src="../js/index.js"></script>
    <script src="../js/useraccount.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/useraccount.css"/>
</head>

<body>

<div class="wrapper">

    <jsp:include page="../headeruseraccount.jsp"/>
    <!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
                <div id="userorders">
                    <table id="tbuserorders">
                        <caption>User orders</caption>
                        <tr>
                            <th>Location</th>
                            <th>Service</th>
                            <th>Speed</th>
                            <th>Price</th>
                        </tr>
                        <tr>
                            <td>34,5</td>
                            <td>3,5</td>
                            <td>36</td>
                            <td>23</td>
                        </tr>
                        <tr>
                            <td>35,5</td>
                            <td>4</td>
                            <td>36⅔</td>
                            <td>23–23,5</td>
                        </tr>
                        <tr>
                            <td>36</td>
                            <td>4,5</td>
                            <td>37⅓</td>
                            <td>23,5</td>
                        </tr>
                        <tr>
                            <td>36,5</td>
                            <td>5</td>
                            <td>38</td>
                            <td>24</td>
                        </tr>
                        <tr>
                            <td>37</td>
                            <td>5,5</td>
                            <td>38⅔</td>
                            <td>24,5</td>
                        </tr>


                    </table>
                </div>

                <div id="panel">
                    <label>Your Disired Location is:</label>
                    <input id="address" type="text" value="Kiev">
                    <input type="button" value="Find" onclick="codeAddress()">
                </div>
                <div id="map_canvas"></div>
            </main>
            <!-- .content -->
        </div>
        <!-- .container-->

        <aside class="left-sidebar">

        </aside>
        <!-- .left-sidebar -->

        <aside class="right-sidebar">
            <strong>Services, available at specified location:</strong>
            <select id="providerselect" size="1"></select>

            <div id="providerservices"></div>

            <div id="btOrder">
                <input type="button" value="Sign Up"></div>
        </aside>
        <!-- .right-sidebar -->

    </div>
    <!-- .middle-->

</div>
<!-- .wrapper -->

<footer class="footer">
    Design and Development by Viacheslav Chernyshov
    <table border="1">
            <%
                for (Service e : DAO.getAllServices()) {
            %>
        <tr>
            <td><%=e.getIdProvider()%>
            </td>
            <td><%=e.getProviderName()%>
            </td>
            <td><%=e.getLongitude()%>
            </td>
            <td><%=e.getLatitude()%>
            </td>
        </tr>
            <%
                }
            %>
</footer>
<!-- .footer -->
<div id="overlay" class="overlay" style="display:none;"></div>
</body>
</html>

