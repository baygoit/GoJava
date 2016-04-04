<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Project</title>
</head>
<body>
	<p>
		<a href="projectsServlet?categoryName=${categoryName}"> Back </a>
	</p>
	<p><b>Project name:</b> ${project.name}</p>
	<p><b>Description:</b> ${project.description}</p>
	<p><b>Needed amount:</b> ${project.neededAmount}</p>
	<p><b>Available amount:</b> ${project.availableAmount}</p>
	<p><b>Remaining days:</b> ${project.daysRemain}</p>
	<p><b>History:</b> ${project.history}</p>
	<p><b>Video:</b> ${project.video}</p>
	<p><b>Q&A:</b></p>
	<c:forEach var="question" items="${questions}" varStatus="varStatus">
		<p>${varStatus.count}Q. ${question.name}</p>
	</c:forEach>
	<hr/>
	<p><b>Ask a question</b></p>
	<form action="projectServlet" method="POST">
		<input type="text" name="question" /> <input type="hidden"
			name="categoryName" value="${categoryName}" /> <input type="hidden"
			name="projectName" value="${projectName}" /> <input type="submit"
			value="Submit" />
	</form>
    <hr/>
	<p>
	   <a href="investmentServlet?categoryName=${categoryName}&projectName=${projectName}">Invest
			in project</a>
	</p>
	
</body>
</html>