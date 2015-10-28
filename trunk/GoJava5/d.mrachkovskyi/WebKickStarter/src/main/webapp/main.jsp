<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1><c:out value="${model.quote.quote}"/></h1>
<h2><c:out value="${model.quote.author}"/></h2>

<h2>Categories</h2>

<c:forEach var="category" items="${model.categoryList}" varStatus="loop">
    <li><c:out value="${loop.index + 1})"/>: <c:out value="${category.name}"/></li>
</c:forEach>

</body>
</html>
