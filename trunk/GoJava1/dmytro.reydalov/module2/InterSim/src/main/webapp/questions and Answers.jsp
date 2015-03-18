<%@page import="ua.com.goit.gojava.solo307.intersim.domain.Interview"%>
<%@page import="ua.com.goit.gojava.solo307.intersim.domain.Category"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questions and answers</title>
</head>
<body bgcolor="Azure">
	<%
		List<Category> categories = Interview.getAllCategories();
			pageContext.setAttribute("categories", categories);
	%>

	<c:forEach items="${categories}" var="category">
		<p>
			<c:out value="Category: "></c:out>
			<c:out value="${category.name}"></c:out>
		</p>
		<br>
		<c:forEach items="${category.questions}" var="question">
			<p>
				<c:out value="Question: "></c:out>
				<c:out value="${question.text}"></c:out>
			</p>
			<p>
				<c:out value="Answers: "></c:out>
			</p>
			<c:forEach items="${question.answers}" var="answer">
				<p>
					<c:out value="${answer.text}"></c:out>
				</p>
			</c:forEach>
			<br>
		</c:forEach>
	</c:forEach>
	<a href="menu.html">Вернуться на главную</a>
	<br>
</body>
</html>