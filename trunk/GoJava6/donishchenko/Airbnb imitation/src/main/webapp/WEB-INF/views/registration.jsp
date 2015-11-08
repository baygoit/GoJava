<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <center>
        <div>
        <form action="/registration" method="POST">
            <table>
                Registration form
                <tr>
                    <td>Login:</td>
                    <td><input type="text" name="login" placeholder="login" value="${requestScope.user.login}"></td>
                </tr>
                <tr>
                    <c:if test="${not empty requestScope.login}">
                        <td></td>
                        <td style="color: red"><c:out value="${requestScope.login}"/></td>
                    </c:if>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" placeholder="password"></td>
                </tr>
                <tr>
                    <c:if test="${not empty requestScope.password}">
                        <td></td>
                        <td style="color: red"><c:out value="${requestScope.password}"/></td>
                    </c:if>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" placeholder="user@cats.com" value="${requestScope.user.email}"></td>
                </tr>
                <tr>
                    <c:if test="${not empty requestScope.email}">
                        <td></td>
                        <td style="color: red"><c:out value="${requestScope.email}"/></td>
                    </c:if>
                </tr>
                <tr><td colspan="2"><input style="width:100%" type="submit" value="Register me!"></td></tr>
            </table>
        </form>
        </div>
    </center>

</body>