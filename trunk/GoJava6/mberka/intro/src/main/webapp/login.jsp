<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Airbnb Login Page</title>
<link rel="stylesheet" href="mainstyle.css" type="text/css">
</head>

<body>
<form method="post" action="LoginController">
    Name:<br>
    <input name="userName">
    <br>
    Surname:<br>
    <input name="userSurname">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>