<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>

<title>Search page</title>
<style>
    .apartment {
        color: purple;
        padding: 10px;
        margin: 10px;
        border: 1px solid orchid;
    }
</style>

</head>
<body>

<a href="/">Go Home</a>
<h1>Available cities:</h1>

<div id="#cities" style="float: left; margin-top: 20px">
    <c:forEach var="city" items="${applicationScope.availableCities}">
        <div><a href="/search?${city.name}">${city.name}</a></div>
    </c:forEach>
</div>

<div id="#apartments" style="float: left;">
    <c:if test="${empty requestScope.apartments}">
        <div style="color: red; margin: 20px;">No apartments</div>
    </c:if>

    <c:forEach var="apartment" items="${requestScope.apartments}">
        <div class="apartment">${apartment.id}: ${apartment.apartmentType}</div>
    </c:forEach>
</div>

</body>
</html>
