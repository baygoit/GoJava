<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="middletext">Комбинация email и пароль неверная</div>
<table class="middle" border="0">
    <caption>Login</caption>

    <tr>

        <td valign="top" align="left">

            <p>Email</p>

            <p>Password</p>

        </td>

        <td>
            <form action="/login" method="POST">

                <p><input type="text" name="email"></p>

                <p><input type="text" name="password"></p>

                <input type="submit" value="Login">
            </form>
        </td>


    </tr>


</table>
</body>
</html>