<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cities</title>
    <link rel="stylesheet" type="text/css" href="/css/airbnb.css">
</head>
<body>
<c:forEach items="${cities}" var="city">
  <h2>${city}<br></h2>
  <form action="/getApartments" method="post">
    <input type="hidden" name="city" value="${city}">
    <input type="submit" value="show apartments">
  </form>
  <img src="img/${city}.jpg" alt="${city}" class="photocard"><br>
  <%--<tr>
    <td>${user.login}</td>
    <td><c:out value="${user.name}" escapeXml="true"/></td>
    <td><a href="mailto:${user.email}">${user.email}</a></td>
    <td><fmt:formatDate value="${user.birthDate}" pattern="dd-MM-yyyy"/></td>
    <td>${user.active ? "Активен" : "Деактивирован"}</td>
    <td><a href="<c:url value="/editUser.html?id=${user.id}"/>">Редактировать</a></td>
  </tr>--%>
</c:forEach>
</body>
</html>
