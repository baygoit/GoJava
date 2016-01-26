<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Become Host</title>
    <link rel="stylesheet" href="mainstyle.css" type="text/css">
</head>

<body>
Hello, <c:out value="${param.userName}"></c:out>
<c:out value="${param.userSurname}"></c:out>!
<br>
<form method="get" action="BecomeHostController">
    Do you want to become a Host User?<br>
    <input type="radio" name="answer" value="YES" /> YES
    <input type="radio" name="answer" value="NO" /> NO
    <input type="Submit" value="Submit">
</form>
</body>
</html>
