<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Projects</title>
</head>
<body>
	<p>
		<a href="category"> Back </a>
	</p>
	<h4>Choose one of the items bellow</h4>
	<c:forEach var="project" items="${projects}" varStatus="varStatus">
		<p>
			${varStatus.count}. <a
				href="project?categoryIndex=${categoryIndex}&projectIndex=${varStatus.index}">${project.name}</a>
		</p>
		<p> Project name:  ${project.name}</p>
        <p> Description:    ${project.description}</p>
        <p> Needed amount:  ${project.neededAmount}</p>
        <p> Available amount:  ${project.availableAmount}</p>
        <p> Remaining days:        ${project.daysRemain}</p>
	</c:forEach>

</body>
</html>