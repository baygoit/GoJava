<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update User Info</title>
</head>
<body>

<center><h1>Welcome ${sessionScope.user.login}!</h1></center>

<div>
    <form action="/profile" method="POST">
        <table style="border: 1px solid black">
            Update User Info
            <c:if test="${not empty requestScope.success}">
                <br><span style="color: green">${requestScope.updateMessage}</span>
            </c:if>
            <tr>
                <td>Your name</td>
                <td><input type="text" name="name" placeholder="name" value="${sessionScope.user.name}"></td>
            </tr>
            <tr>
                <c:if test="${not empty requestScope.name}">
                    <td></td>
                    <td style="color: red"><c:out value="${requestScope.name}"/></td>
                </c:if>
            </tr>
            <tr>
                <td>Your surname</td>
                <td><input type="text" name="surname" placeholder="surname" value="${sessionScope.user.surname}"></td>
            </tr>
            <tr>
                <c:if test="${not empty requestScope.surname}">
                    <td></td>
                    <td style="color: red"><c:out value="${requestScope.surname}"/></td>
                </c:if>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" placeholder="user@cats.com" value="${sessionScope.user.email}"></td>
            </tr>
            <tr>
                <c:if test="${not empty requestScope.email}">
                    <td></td>
                    <td style="color: red"><c:out value="${requestScope.email}"/></td>
                </c:if>
            </tr>
            <tr>
                <td colspan="2"><input style="width: 100%" type="submit" value="Save changes"></td>
            </tr>
        </table>
    </form>

    <a href="/">Home</a>
</div>

</body>