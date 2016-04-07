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
	<c:forEach var="project" items="${projects}" varStatus="varStatus">
		<p>
			${varStatus.count}. <a
				href="projectServlet?categoryName=${categoryName}&projectName=${project.name}">${project.name}</a>
		</p>
		<h3>${project.name}</h3>
		<p> <b>Project name:</b>        ${project.name}</p>
        <p> <b>Description:</b>         ${project.description}</p>
        <p> <b>Needed amount:</b>       ${project.neededAmount}</p>
        <p> <b>Available amount:</b>    ${project.availableAmount}</p>
        <p> <b>Remaining days:</b>      ${project.daysRemain}</p>
	</c:forEach>

</body>
</html>