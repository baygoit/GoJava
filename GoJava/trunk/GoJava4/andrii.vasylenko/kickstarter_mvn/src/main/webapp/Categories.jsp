<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kickstarter: Categories</title>
</head>
<body>
	<h1>CHOICE CATEGORY:</h1>
	<c:forEach var="category" items="${categories}">
		<h2>
			<a href="/kickstarter/projects?category=${category.id}">
				<c:out value="${category.name}" />
			</a>
		</h2>
	</c:forEach>
</body>
</html>