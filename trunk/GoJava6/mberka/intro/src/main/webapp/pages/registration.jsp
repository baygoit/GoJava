<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Airbnb Registration</title>
    <link rel="stylesheet" href="mainstyle.css" type="text/css">
</head>

<body>
    <form name="registerForm" method="post" action="RegistrationController" action="becomeHost.jsp">
        Name:<br>
        <input name="userName">
        <br>
        Surname:<br>
        <input name="userSurname">
        <br>
        Email:<br>
        <input name="email">
        <br>
        City:<br>
        <input name="userCity">
        <br>
        <input type="submit" value="Register on Airbnb" formaction="becomeHost.jsp">
    </form>
</body>
</html>