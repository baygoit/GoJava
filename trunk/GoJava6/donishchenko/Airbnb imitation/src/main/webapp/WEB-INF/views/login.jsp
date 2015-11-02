<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<center>
    <div>
        <form action="/login" method="POST">
            <table>
                Login form
                <tr>
                    <td>Login:</td>
                    <td><input type="text" name="login" placeholder="login"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" placeholder="password"></td>
                </tr>
                <tr><td colspan="2"><input style="width:100%" type="submit" value="Login"></td></tr>
                <tr><td colspan="2"><a href="/registration">Registration</a></td></tr>
            </table>
        </form>
    </div>
</center>

</body>