<%@page import="ua.com.goit.gojava.solo307.intersim.domain.*"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>custom</title>
</head>
<body bgcolor="Azure">
	<%
		List<Question> questions = (List<Question>) request
				.getAttribute("questions");
		pageContext.setAttribute("questions", questions);
	%>
	<form action="Controller" method="Post">
		<c:forEach items="${questions}" var="question">
			<p>
				<c:out value="${question.text}"></c:out>
			</p>
			<c:forEach items="${question.answers}" var="answer">
				<p>
					<input type="checkbox" name="answer" value="${answer.id}">
					<c:out value="${answer.text}"></c:out>
				</p>
			</c:forEach>
		</c:forEach>
		<p>
			<input type="submit" value="Submit">
		</p>
	</form>
	<a href="menu.html">Вернуться на главную</a>
	<br>
</body>
</html>