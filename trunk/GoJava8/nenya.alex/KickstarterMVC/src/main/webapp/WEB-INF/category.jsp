<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<title>Projects</title>
</head>
<body>
	<p>
		<a href="<c:url value="/"/>"> Back </a>
	</p>

	<h4>Choose one of the items bellow</h4>
	<c:forEach var="project" items="${projects}">

		<p>
			<a
				href="<c:url value="/category/project/${project.id}"/>" >${project.name}</a>
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
			<b>Available amount:</b> ${project.availableAmount}
		</p>
		<p>
			<b>Remaining days:</b> ${project.remainingDays}
		</p>
	</c:forEach>

</body>
</html>