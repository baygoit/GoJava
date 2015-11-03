<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update User Info</title>
</head>
<body>

<center><h1>Welcome User!</h1></center>

<div>
    <form action="/profile" method="POST">
        <table style="border: 1px solid black">
            Update User Info
            <input type="text" hidden name="id" value="${sessionScope.user.id}">
            <tr>
                <td>Your name</td>
                <td><input type="text" name="name" placeholder="name" value="${sessionScope.user.name}"></td>
            </tr>
            <tr>
                <td>Your surname</td>
                <td><input type="text" name="surname" placeholder="surname" value="${sessionScope.user.surname}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" placeholder="user@cats.com" value="${sessionScope.user.email}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save changes"></td>
            </tr>
        </table>
    </form>
</div>

</body>