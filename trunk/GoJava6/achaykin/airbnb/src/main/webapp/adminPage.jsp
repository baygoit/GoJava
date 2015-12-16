<%@ page import="org.apache.logging.log4j.Logger" %>
<%@ page import="org.apache.logging.log4j.LogManager" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 09.12.2015
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin page</title>
</head>
<body>
<%
String user = null;
    if(session.getAttribute("admin") == null) {
//        response.sendRedirect("index.html");
    } else {
        user = (String)session.getAttribute("admin");
    }

    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();

    if(cookies != null) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("admin")) {
                userName = cookie.getValue();
            } else if (cookie.getName().equals("JSESSIONID")) {
                sessionID = cookie.getValue();
            }
        }
    }
    if(userName == null) {
        response.sendRedirect("index.html");
    }
%>

<h4>This is your admin page, master!</h4>
<h5>Your session id is </h5> <%=sessionID%>

<form action="/logout" method="post">
    <input type="submit" value="logout">
</form>
</body>
</html>