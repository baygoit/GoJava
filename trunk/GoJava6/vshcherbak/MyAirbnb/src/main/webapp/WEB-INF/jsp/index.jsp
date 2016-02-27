<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>WelCome</title>
    <link rel="stylesheet" type="text/css" href="/css/airbnb.css">
</head>

<body >
    <marquee><h2>Attention, this site made only for training. It is not real servis.</h2></marquee>
    <br><br>
    <p>${message}</p>
    <br><br>
    <form  action="showCities" method="POST">
        <input type="submit" value="Show available cities"><br>
    </form>
    <br>
    <form  action="register" method="POST">
        <input type="submit" value="register"><br>
    </form>
    <br>
    <form  action="/login" method="POST">
        <input type="submit" value="login"><br>
    </form>
    <br>
    <c:if test="${log == 'in'}">
        <%--User Id <c:out value="${userID}"/>--%>
        <c:if test="${type == 'host'}">
            <form  action="/apartment" method="POST">
                <input type="hidden" name="userID" value="${userID}">
                <input type="submit" value="register apartment"><br>
            </form>
            <br>
            <form  action="/showMyApartments" method="POST">
                <input type="hidden" name="userID" value="${userID}">
                <input type="submit" value="show my apartments"><br>
            </form>
        </c:if>
        <br>
        <form  action="/reservation" method="POST">
            <input type="hidden" name="userID" value="${userID}">
            <input type="submit" value="make registration"><br>
        </form>
    </c:if>
</body>
</html>
