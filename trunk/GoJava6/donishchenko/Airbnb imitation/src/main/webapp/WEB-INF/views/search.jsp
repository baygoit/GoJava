<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Search page</title>
</head>
<body>

<h1>Available cities:</h1>

<div id="#cities">
    <c:forEach var="city" items="${requestScope.cities}">
        <a href="/search?city=${city}">${city}</a>
    </c:forEach>
</div>

</body>
</html>
