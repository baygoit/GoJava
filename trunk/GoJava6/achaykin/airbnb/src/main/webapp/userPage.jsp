<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 09.12.2015
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="US-ACII">
    <title>Login success</title>
</head>
<body>
<%
    String user = null;

    if(session.getAttribute("user") == null) {
//        response.sendRedirect("index.html");
    } else {
        user = (String)session.getAttribute("user");
    }

    String username = null;
    String sessionID = null;

    Cookie[] cookies = request.getCookies();

    if(cookies != null) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("user")) {
                username = cookie.getValue();
            } else if(cookie.getName().equals("JSESSIONID")) {
                sessionID = cookie.getValue();
            }
        }
    }

    if(username == null) {
        response.sendRedirect("/index.html");
    }
%>

<h3>Hello, <%=username%>! Welcome on board!></h3>
<%=username%>, your session id is <%=sessionID%>!
<br>
<form action="/logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
