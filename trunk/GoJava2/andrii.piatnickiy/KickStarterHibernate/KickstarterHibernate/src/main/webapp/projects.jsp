<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects</title>
</head>
<body>
	<c:forEach var="project" items="${projects}">
		<p>
			<a href="/KickstarterMaven/project?project=${project.name}">${project.name}</a><br>
			${project.description}<br>
			${project.needSum}<br>
			${project.currentSum}<br>
			${project.daysLeft}<br>
			${project.projectHistory}<br>
			${project.linkOnvideo}<br>
			${project.questionsAndAnswers}<br>
		</p>
	</c:forEach>
</body>
</html>