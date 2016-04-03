<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

	<h2>${project.name}</h2>
	<p>Description: ${project.description}</p>
	<p>Required budget: ${project.requiredBudget}</p>
	<p>Gathered budget: ${project.gatheredBudget}</p>
	<p>Days left: ${project.daysLeft}</p>
	<p>History: ${project.history}</p>
	<p>Video URL: ${project.url}</p>
	
	<h3>Question:</h3>
	

<jsp:include page="footer.jsp" />