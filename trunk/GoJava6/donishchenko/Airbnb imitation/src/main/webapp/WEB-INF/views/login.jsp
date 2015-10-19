<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title> Login JSP </title>
    </head>
    <body>
        <form action="/login" method="POST">
            <input type="text" name="username" value="test">
            <input type="submit" value="Log in">
        </form>
    </body>
</html>