<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Project</title>
</head>
<body>

	<p>
		<a href="<c:url value="/category/${category.id}"/>" > <spring:message code="category.back" /> </a>
	</p>
	<p><b><spring:message code="project.name" />:</b> ${project.name}</p>	
	<p><b><spring:message code="project.description" />:</b> ${project.description}</p>
	<p><b><spring:message code="project.neededAmount" />:</b> ${project.neededAmount}</p>
	<p><b><spring:message code="project.availableAmount" />:</b> ${project.availableAmount} </p>
	<p><b><spring:message code="project.remainingDays" />:</b> ${project.remainingDays}</p>
	<p><b><spring:message code="project.history" />:</b> ${project.history}</p>
	<p><b><spring:message code="project.video" />:</b> ${project.video}</p>
	<p><b><spring:message code="project.questions" />:</b></p>
	<c:forEach var="question" items="${questions}" varStatus="varStatus">
		<p>${varStatus.count}<spring:message code="project.q" />. ${question.name}</p>
	</c:forEach>
    <p>    
            <a href="<c:url value="/question/${project.id}"/>" ><spring:message code="project.ask" /></a>
    </p>
	<p>	   
			<a href="<c:url value="/payment/${project.id}"/>" ><spring:message code="project.invest" /></a>
	</p>
	
</body>
</html>