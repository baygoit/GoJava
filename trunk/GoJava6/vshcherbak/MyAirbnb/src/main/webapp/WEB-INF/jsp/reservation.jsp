<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>reservation</title>
  <link rel="stylesheet" type="text/css" href="/css/airbnb.css">
</head>
<body>
<h2>${message} </h2>
<br>
<c:forEach items="${cities}" var="city">
  <h2>${city}<br></h2>
  <form action="/searchApartments" method="post">
    <input type="hidden" name="city" value="${city}">
    <input type="hidden" name="userID" value="${userID}">
    Date begin:
    <input type="text" name="start" value="20-01-2015">
    Date end:
    <input type="text" name="end" value="23-04-2015">
    <input type="submit" value="search">
  </form>
  <%--<img src="img/${city}.jpg" alt="${city}" class="photocard"><br>--%>
</c:forEach>
<table>
    <tr>
            <%--<td>id</td>--%>
        <td>city</td>
        <td>street</td>
        <td>house</td>
        <td>room</td>
        <td>rent</td>
        <td>Comments (if need)</td>
    </tr>

<c:forEach items="${apartments}" var="apartment">
    <tr>
            <%--<td><c:out value="${apartment.apartmentID}"/></td>--%>
        <td><c:out value="${apartment.city}"/></td>
        <td><c:out value="${apartment.street}"/></td>
        <td><c:out value="${apartment.house}"/></td>
        <td><c:out value="${apartment.room}"/></td>
        <td><c:out value="${apartment.rent}"/></td>
        <td>
                <form action="/registerReservation" method="post">
                    <input type="hidden" name="apartmentID" value="${apartment.apartmentID}">
                    <input type="hidden" name="userID" value="${userID}">
                    <input type="hidden" name="start" value="${start}">
                    <input type="hidden" name="end" value="${end}">
                    <input type="text" name="comments">
                    <input type="submit" value="reserv">
                </form>
        </td>
    </tr>
</c:forEach>
    </table>
<br>
<%--<form action="/registerReservation" method="post">
    <input type="hidden" name="apartmentID" value="21">
    <input type="hidden" name="userID" value="3">
    <input type="hidden" name="start" value="20-01-2015">
    <input type="hidden" name="end" value="23-04-2015">
    <input type="text" name="comments" value="test">
    <input type="submit" value="reserv">
</form>--%>
</body>
</html>
<%--<tr>
    <td>${user.login}</td>
    <td><c:out value="${user.name}" escapeXml="true"/></td>
    <td><a href="mailto:${user.email}">${user.email}</a></td>
    <td><fmt:formatDate value="${user.birthDate}" pattern="dd-MM-yyyy"/></td>
    <td>${user.active ? "Активен" : "Деактивирован"}</td>
    <td><a href="<c:url value="/editUser.html?id=${user.id}"/>">Редактировать</a></td>
  </tr>--%>