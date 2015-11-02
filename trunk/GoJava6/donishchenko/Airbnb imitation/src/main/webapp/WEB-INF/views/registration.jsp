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
                    <td><input type="text" name="login" placeholder="login"></td>
                </tr>
                <tr>
                    <td>Surname:</td>
                    <td><input type="text" name="surname" placeholder="surname"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" placeholder="user@cats.com"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" placeholder="password"></td>
                </tr>
                <tr><td colspan="2"><input style="width:100%" type="submit" value="Register me!"></td></tr>
            </table>
        </form>
        </div>
    </center>

</body>