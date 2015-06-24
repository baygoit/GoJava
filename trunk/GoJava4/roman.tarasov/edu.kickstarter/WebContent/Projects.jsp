<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Projects</title>
</head>
<body>
	<h1>PROJECTS</h1>
	<input type="button" value="main page"
		onclick="self.location='main';" />
	<c:forEach var="project" items="${sortedProjects}">
		<h2>
			<a
				href="DetailedProject?project=${project.ID}&category=${project.categoryID}">
				<c:out value="${project.name}" />
			</a>
		</h2>

		<c:out value=" shortDescription= ${project.shortDescription}" />
		<br>
		<c:out value=" goal= ${project.goal}" />
		<br>
		<c:out value=" pledged= ${project.pledged}" />
		<br>
		<c:out value=" daysToGo= ${project.daysToGo}" />
		<br>
	</c:forEach>
	<input type="button" value="main page"
		onclick="self.location='main';" />

</body>
</html>