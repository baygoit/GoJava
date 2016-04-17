<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Projects</title>
</head>
<body>
	<p>
		<a href="categoryServlet"> Back </a>
	</p>
	<h4>Choose one of the items bellow</h4>
	<c:forEach var="project" items="${projects}">
		<p>
			<a
				href="projectServlet?categoryId=${categoryId}&projectId=${project.id}">${project.name}</a>
		</p>
		<p>
			<b>Project name:</b> ${project.name}
		</p>
		<p>
			<b>Description:</b> ${project.description}
		</p>
		<p>
			<b>Needed amount:</b> ${project.neededAmount}
		</p>
		<p>
			<b>Available amount:</b>????
		</p>
		<p>
			<b>Remaining days:</b> ${project.daysRemain}
		</p>
	</c:forEach>

</body>
</html>