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
			<a href="/KickstarterWeb/project?project=${project.getName()}">${project.getName()}</a><br>
			${project.getDescription()}<br>
			${project.getNeedSum()}<br>
			${project.getCurrentSum()}<br>
			${project.getDaysLeft()}<br>
			${project.getProjectHistory()}<br>
			${project.getLinkOnvideo()}<br>
			${project.getQuestionsAndAnswers()}<br>
		</p>
	</c:forEach>
</body>
</html>