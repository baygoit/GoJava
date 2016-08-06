<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects</title>
</head>
<body>

	<h3><a href="categories">Change category</a></h3>
	<h2>${category.getName()} projects</h2>
	<br>
	<br>
	<c:forEach var="project" items="${projects}">
		<a href="project?project_id=${project.getId()}&category_id=${category.getId()}">${project.getName()}</a>
		<br>
		Necessary amount: <c:out value="${project.getRequiredSum()}"/>
		<br>
		Collected amount: <c:out value="${project.getCollectedSum()}"/>
		<br>
		Days left: <c:out value="${project.getEndOfDays()}"/>
		<br>
		<br>
	</c:forEach>

</body>
</html>