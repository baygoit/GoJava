<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>catalog</title>
</head>
<body>
	<p><c:out value="${quote.quote}" /></p>
	<c:forEach items="${categories}" var="category">
		<a href="projects/${category.id}"><c:out value="${category.name}" /></a>
		<p>
	</c:forEach>
	<a href="addCategory"><c:out value="Add new category"/></a>
</body>
</html>