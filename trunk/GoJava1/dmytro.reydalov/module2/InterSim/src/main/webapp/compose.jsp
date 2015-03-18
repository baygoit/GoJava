<%@ page import="ua.com.goit.gojava.solo307.intersim.domain.Category"%>
<%@ page import="ua.com.goit.gojava.solo307.intersim.domain.Interview"%>
<%@ page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compose your categories</title>
</head bgcolor="Azure" >
<body>
	<p>Compose your categories</p>
	<%
		List<Category> categories = Interview.getAllCategories();
		pageContext.setAttribute("mycategories", categories);
	%>
	<form action="Composer" method="Post">
		<c:forEach items="${mycategories}" var="category">
			<p>
				<input type="checkbox" name="category" value="${category.name}">
				<c:out value="${category.name}"></c:out>
			</p>
		</c:forEach>
		<p>
			<input type="submit" value="Submit">
		</p>
		<a href="menu.html">Вернуться на главную</a>
	</form>
</body>
</html>