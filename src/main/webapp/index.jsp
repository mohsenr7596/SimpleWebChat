<%--
  Created by IntelliJ IDEA.
  User: Nima
  Date: 26/03/2017
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        Boolean login = (Boolean) session.getAttribute("login");
        String username = "";

        if (login == null) {
            login = Boolean.FALSE;
        } else {
            username = (String) session.getAttribute("username");
        }
    %>
</head>
<body>

<%
    if (login) {
%>

<p>Hello <%=username%>
</p>
Welcome

<%
} else {
%>

<p>Welcome Please login first <a href="login.xhtml">Login!</a></p>

<%
    }
%>

</body>
</html>
