<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Main</title>

</head>
<body background="">
	<h1>Kickstarter</h1>
	<c:forEach var="category" items="${categories}">
		<h2>
			<a href="projects?category=${category.ID}"> <c:out
					value="${category.name}" />
			</a>
		</h2>
	</c:forEach>
	<h1>
		<c:out value="${quote.quote}" />
	</h1>

</body>
</html>