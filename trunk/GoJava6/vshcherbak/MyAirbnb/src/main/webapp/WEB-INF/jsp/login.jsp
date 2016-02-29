<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="/css/airbnb.css">
</head>
<body>
<c:out value="${message}"/>
<br>
<form action="loginUser" method="post">
  Login:<br>
  <input type="text" name="login"><br>
  Email:  <br>
  <input type="text" name="email" value="baker@site.com"><br>
  Password:<br>
  <input type="text" name="password" value="1111"><br>
  <input type="submit" value="input">
</form>
</body>
</html>
