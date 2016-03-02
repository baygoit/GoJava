<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="/css/airbnb.css">
</head>
<body>
  <c:out value="${message}"/>
   <form action="registerUser" method="post">
     First name:<br>
     <input type="text" name="firstname"><br>
     Last name:<br>
     <input type="text" name="lastname"><br>
     Email:<br>
     <input type="text" name="email"><br>
     Login:<br>
     <input type="text" name="login"><br>
     Password:<br>
     <input type="text" name="password"><br>
     <input type="radio" name="type" value="client" checked> Client<br>
     <input type="radio" name="type" value="host"> Host<br>
     <input type="radio" name="notify" value="yes" checked> Notify On<br>
     <input type="radio" name="notify" value="no"> Notify Off<br>
     <input type="submit" value="Save">
   </form>
</body>
</html>
