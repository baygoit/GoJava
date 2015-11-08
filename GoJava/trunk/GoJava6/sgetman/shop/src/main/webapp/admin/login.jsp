<%--
  Created by IntelliJ IDEA.
  User: sergiigetman
  Date: 10/30/15
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
  <form action="/login" method="post">
    Username: <input type="text" name="user">
    <br>
    Password: <input type="password" name="pass">
    <br>
    <input type="submit" value="Login">
  </form>

</body>
</html>
