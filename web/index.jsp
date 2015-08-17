<%@page contentType="text/html" pageEncoding="UTF-8" import="com.flower.dao.*" %>
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
    <script src="js/action.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
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
        </aside>
        <!-- .right-sidebar -->
    </div>
    <!-- .middle-->
    <footer class="footer">
        <strong>Footer:</strong>

        <table border="1">
            <%
                for (Provider e : DAO.getProvider()) {
            %>
            <tr>
                <td><%=e.getProviderId()%>
                </td>
                <td><%=e.getProvider()%>
                </td>
                <td><%=e.getlongitude()%>
                </td>
                <td><%=e.getlatitude()%>
                </td>
            </tr>
            <%
                }
            %>
        </table>

    </footer>
    <!-- .footer -->
</div>
<!-- .wrapper -->
<script type="text/javascript">
    function initlocation() {
        /*alert();
         var array_provider_location = new Array();

         for (i=0;i<5;i++){
         array_provider_location[i]
         }*/


        /*array_provider_location = new Array(
         {
         "providerlocationlat": "50.45095993",
         providerlocationlng: "30.52259982",
         "providertitle": "Main office"
         },
         {
         "providerlocationlat": "50.4282552",
         providerlocationlng: "30.4529175",
         "providertitle": "Solomenka office"
         },
         {
         "providerlocationlat": "50.4535873",
         providerlocationlng: "30.601521",
         "providertitle": "Darnitsa office"
         },
         {
         "providerlocationlat": "50.397944",
         providerlocationlng: "30.634579",
         "providertitle": "Pozniaki office"
         },
         {
         "providerlocationlat": "50.526944",
         providerlocationlng: "30.492778",
         "providertitle": "Obolon office"
         }
         )*/

    }
</script>
</body>
</html>
