<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="header.jsp">
	<jsp:param value="Donation Successful" name="title"/>
</jsp:include>
<%@page session="true"%>
<meta http-equiv="Refresh" content="3;url=/kickstarter/project?id=${payment.project.id}">
<%@ page session="false" %>	
	You will be redirected to the project page in 3 seconds.
	<strong>Your payment: $${payment.amount}</strong><br>
	
	
	
	<jsp:include page="footer.jsp" />