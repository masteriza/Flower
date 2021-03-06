<%@page contentType="text/html" pageEncoding="UTF-8" import="com.flower.dao.*" %>
<%@ page import="com.flower.Service" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>

    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&libraries=geometry"></script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script src="../js/useraccount.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/useraccount1.css"/>
</head>

<body>

<jsp:useBean class="com.flower.dao.DAO" id="DAO" scope="application"/>


<div class="wrapper">
    <header class="header">
        <strong>Header:</strong>
    </header>
    <!-- .header-->
    <div class="middle">

        <div class="container">
            <main class="content">
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
            <!-- <strong>Left Sidebar:</strong>-->
        </aside>
        <!-- .left-sidebar -->
        <aside class="right-sidebar">
            <strong>Services, available at specified location:</strong>

            <select id="providerselect" size="1"></select>
            <div id="providerservices"></div>
        </aside>
        <!-- .right-sidebar -->
    </div>
    <!-- .middle-->
    <footer class="footer">
        <strong>Footer:</strong>

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
        </table>
        <div id="somediv"></div>
    </footer>


    <!-- .footer -->
</div>
<!-- .wrapper -->

</body>
</html>
