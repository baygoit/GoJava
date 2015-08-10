<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h1>This is jsp with jstl</h1>

<c:choose>
    <c:when test="${!empty param.username}">
        <h2>Hello <c:out value="${param.username}"/> </h2>
    </c:when>
    <c:otherwise>
        <h2>Hello, whoever you are!</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
