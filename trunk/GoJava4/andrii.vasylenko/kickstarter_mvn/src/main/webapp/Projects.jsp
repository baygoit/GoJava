<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kickstarter: Projects</title>
</head>
<body>
	<h1>CHOICE PROJECT:</h1>
	<c:forEach var="project" items="${projects}">
		<h2>
			<a href="/kickstarter/project?project=${project.id}&category=${project.categoryId}"> 
				<c:out value="${project.name}" />
			</a>
		</h2>
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
		<br />
	</c:forEach>
	<br />
	<br />
	<h3>
		<a href="/kickstarter/categories"> 
			<c:out value="<- back to categories" />
		</a>
	</h3>
</body>
</html>