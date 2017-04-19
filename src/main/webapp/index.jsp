<%@ page import="com.example.G" %>
<%@ page import="com.example.Global" %>
<%--
  Created by IntelliJ IDEA.
  Date: 26/03/2017
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>--%>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%
        Boolean login = (Boolean) session.getAttribute("login");
        String username = "";

        if (login == null) {
            login = Boolean.FALSE;
        } else {
            username = (String) session.getAttribute("username");
        }
    %>

    <%--JQuery for auto refresh--%>
    <script type="text/javascript">

        $('#something').click(function () {
            location.reload();
        });

    </script>

    <!--Click Listener-->
    <script>
        var x = document.getElementsByClassName("list-group-item");
        for (var i = 0; i < x.length; i++) {
            x[i].onclick = function () {
                console.log("AAAAAAAAA");
            }
        }
    </script>

</head>
<body>

<%
    if (login) {
%>

<div class="container">
    <h2>List Online Users</h2>
    <div class="list-group">
        <%
            Global global = (Global) request.getSession().getServletContext().getAttribute(G.GLOBAL);
            for (String s : global.UserList()) {

        %>

        <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading"><%=s%>
            </h4>
            <p class="list-group-item-text">Online</p>
        </a>

        <%
            }
        %>
    </div>
</div>

<%
} else {
%>

<p>Welcome Please login first <a href="login.xhtml">Login!</a></p>

<%
    }
%>

</body>
</html>
