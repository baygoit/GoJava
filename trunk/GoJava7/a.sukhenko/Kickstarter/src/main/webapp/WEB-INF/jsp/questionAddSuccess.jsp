<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="header.jsp">
	<jsp:param value="Question Added" name="title"/>
</jsp:include>
<meta http-equiv="Refresh" content="3;url=/kickstarter/project?id=${question.project.id}">
<%@ page session="false" %>	
	You will be redirected to the project page in 3 seconds.
	<strong>Your question: ${question.question}</strong><br>
	
	
	
	<jsp:include page="footer.jsp" />