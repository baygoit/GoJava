<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
  <link rel="stylesheet" type="text/css" href="/css/airbnb.css">
</head>
<body>
<c:out value="${message}"/>
<br>
<form action="/registerApartment" method="post">
  <input type="hidden" name="userID" value="${userID}">
  City:<br>
  <input type="text" name="city"><br>
  Street:<br>
  <input type="text" name="street"><br>
  House (number):<br>
  <input type="text" name="house"><br>
  Room (number):<br>
  <input type="text" name="room"><br>
  Comments:<br>
  <input type="text" name="comments"><br>
  Type:
  <input type="radio" name="rent" value="apartment" checked>apartment<br>
  <input type="radio" name="rent" value="room">room<br>
  <input type="radio" name="rent" value="place">place<br>
<br>
  <input type="submit" value="Save">
</form>

</body>
</html>
