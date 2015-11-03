<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        #userInfo td {
            border: 1px solid black;
        }
    </style>

</head>
<body>

<center><h1>Welcome User!</h1></center>

<div id="userInfo">
    <table style="border: 1px solid black">
        User Info
        <tr>
            <td>Your name</td><td><c:out value="${sessionScope.user.name}" /></td>
        </tr>
        <tr>
            <td>Your surname</td><td><c:out value="${sessionScope.user.surname}" /></td>
        </tr>
        <tr>
            <td>Email</td><td><c:out value="${sessionScope.user.email}" /></td>
        </tr>
        <tr>
            <td colspan="2"><a href="/profile">Edit</a></td>
        </tr>
    </table>

    <a href="/logout">Log out</a>
</div>

</body>