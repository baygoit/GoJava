<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Project</title>
</head>
<body>
	<p>
		<a href="<c:url value="/category/${category.id}"/>" > Back </a>
	</p>
	<p><b>Project name:</b> ${project.name}</p>
	<p><b>Description:</b> ${project.description}</p>
	<p><b>Needed amount:</b> ${project.neededAmount}</p>
	<p><b>Available amount:</b> ${project.availableAmount} </p>
	<p><b>Remaining days:</b> ${project.remainingDays}</p>
	<p><b>History:</b> ${project.history}</p>
	<p><b>Video:</b> ${project.video}</p>
	<p><b>Q&A:</b></p>
	<c:forEach var="question" items="${questions}" varStatus="varStatus">
		<p>${varStatus.count}Q. ${question.name}</p>
	</c:forEach>
	<hr/>
	<p><b>Ask a question for project "${project.name}"</b></p>
	<form:form action="add" method="post" modelAttribute="questionForm">
        <form:input type="text" path="name" required="required"/> 
        <form:input type="hidden" path="project.id" value="${project.id}" /> 
        <input type="submit" value="Submit" />
    </form:form>
	<p>	   
			<a href="<c:url value="/category/project/payment/${project.id}"/>" >Invest in project</a>
	</p>
	
</body>
</html>