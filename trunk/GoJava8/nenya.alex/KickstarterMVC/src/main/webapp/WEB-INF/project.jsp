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
		<a href="<c:url value="/category/${category.id}"/>" > Back </a>
	</p>
	<span>
	    <a href="?lang=en">en</a> 
	    | 
	    <a href="?lang=ru">ru</a>
    </span>
	<p><b>Project name:</b> ${project.name}</p>
	
	<fmt:message key="project.name"></fmt:message>
	
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
    <p>    
            <a href="<c:url value="/question/${project.id}"/>" >Ask a question</a>
    </p>
	<p>	   
			<a href="<c:url value="/payment/${project.id}"/>" >Invest in project</a>
	</p>
	
</body>
</html>