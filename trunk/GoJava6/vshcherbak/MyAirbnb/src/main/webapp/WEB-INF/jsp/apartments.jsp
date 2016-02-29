<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>cities</title>
  <link rel="stylesheet" type="text/css" href="/css/airbnb.css">
</head>
<body>
<table>
<tr>
  <%--<td>id</td>--%>
  <td>city</td>
  <td>street</td>
  <td>house</td>
  <td>room</td>
  <td>rent</td>
  <td>action</td>
</tr>
<p><h2>${message}</h2></p><br>
<c:forEach items="${apartments}" var="apartment">
  <tr>
    <%--<td><c:out value="${apartment.apartmentID}"/></td>--%>
    <td><c:out value="${apartment.city}"/></td>
    <td><c:out value="${apartment.street}"/></td>
    <td><c:out value="${apartment.house}"/></td>
    <td><c:out value="${apartment.room}"/></td>
    <td><c:out value="${apartment.rent}"/></td>
    <td>
      <c:if test="${type == 'host'}">
      <form action="/deleteApartment" method="post">
      <input type="hidden" name="apartmentID" value="${apartment.apartmentID}">
      <input type="hidden" name="userID" value="${userID}">
      <input type="submit" value="delete">
    </form></c:if>
    </td>
  </tr>
</c:forEach>
</table>
<%--<c:if test="${type == 'host'}">
<p>host<p>
  </c:if>
  <c:if test="${type == 'client'}">
<p>client<p>
  </c:if>--%>
</body>
</html>
