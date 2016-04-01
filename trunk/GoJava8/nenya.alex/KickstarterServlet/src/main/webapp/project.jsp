<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Project</title>
</head>
<body>
	<p>
		<a href="projects?categoryIndex=${categoryIndex}"> Back </a>
	</p>
	<p>Project name: ${project.name}</p>
	<p>Description: ${project.description}</p>
	<p>Needed amount: ${project.neededAmount}</p>
	<p>Available amount: ${project.availableAmount}</p>
	<p>Remaining days: ${project.daysRemain}</p>
	<p>History: project.history</p>
	<p>Video: project.video</p>
	<p>Q&A:</p>
	<c:forEach var="question" items="${questions}" varStatus="varStatus">
		<p>${varStatus.count}. ${question.name}</p>
	</c:forEach>
	<p>
	   <a href="investment?categoryIndex=${categoryIndex}&projectIndex=${projectIndex}">Invest
			in project</a>
	</p>
	<p>
		<a href="question?categoryIndex=${categoryIndex}&projectIndex=${projectIndex}">Ask
			a question</a>
	</p>
</body>
</html>