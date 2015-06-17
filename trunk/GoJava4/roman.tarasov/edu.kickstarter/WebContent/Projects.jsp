<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects</title>
</head>
<body>
	<h1>PROJECTS.</h1>
	<input type="button" value="main page"
		onclick="self.location='${previous}';" />
	<c:forEach var="project" items="${sortedProjects}">
		<h2>
			<a
				href="/edu.kickstarter/detailedProject?project=${project.ID}&category=${project.categoryID}">
				<c:out value="${project.name}" />
			</a>
		</h2>
		<h3>
			<c:out value=" shortDescription= ${project.shortDescription}" />
		</h3>
		<h3>
			<c:out value=" goal= ${project.goal}" />
		</h3>
		<h3>
			<c:out value=" pledged= ${project.pledged}" />
		</h3>
		<h3>
			<c:out value=" daysToGo= ${project.daysToGo}" />
		</h3>
		<br />
	</c:forEach>
	<input type="button" value="main page"
		onclick="self.location='${previous}';" />

</body>
</html>