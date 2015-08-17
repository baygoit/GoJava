<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kickstarter</title>
</head>
<body>
    <h1><c:out value="${quote}"/></h1>
    <br>
    <h2>Categories:</h2>
    <ol>
    <c:forEach var="category" items="${categories}">
        <li><a href="projects?categoryId=${category.id}"><c:out value="${category.name}"/></a></li>
    </c:forEach>
    </ol>
</body>
</html>
