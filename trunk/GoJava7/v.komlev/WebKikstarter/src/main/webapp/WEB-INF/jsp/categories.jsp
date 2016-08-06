<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First page categories</title>
</head>
<body>

	${content}
	<br>
	&copy; <i>${author}</i>
	<br>
	<h2>Categories</h2>
	<ul>
		<c:forEach var="category" items="${categories}">
			<li>
				<a href="category?category_id=${category.id}">${category.name}</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>