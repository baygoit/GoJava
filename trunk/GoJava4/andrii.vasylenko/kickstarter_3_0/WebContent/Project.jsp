<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kickstarter: Project</title>
</head>
<body>
	<h1>PROJECT:</h1>
	<h1>
		<c:out value="${project.name}" />
	</h1>
	<h3>
		<c:out value=" description= ${project.description}" />
	</h3>
	<h3>
		<c:out value=" totalAmount= ${project.totalAmount}" />
	</h3>
	<h3>
		<c:out value=" collectAmount= ${project.collectAmount}" />
	</h3>
	<h3>
		<c:out value=" daysLeft= ${project.daysLeft}" />
	</h3>
	<h3>
		<c:out value=" history= ${project.history}" />
	</h3>
	<h3>
		<c:out value=" link= ${project.link}" />
	</h3>
	<h3>
		Questions and answers:
	</h3>
	<c:forEach var="question" items="${project.questionsAndAnswers}">
		<h3>
			<c:out value=" question= ${question}" />
		</h3>
	</c:forEach>
	<br />
	<br />
	<h3>
		<a href="/kickstarter/projects?category=${project.categoryId}"> 
			<c:out value="<- back to projects" />
		</a>
	</h3></body>
</html>