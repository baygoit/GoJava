<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="title" scope="request">
	<spring:message code="error.error" />
</c:set>
<jsp:include page="errorHeader.jsp" />
		<h1><spring:message code="error.error" />: 400</h1>
		<h2><spring:message code="error.badRequest" /></h2>
		<hr/>
		<br/>
		<spring:message code="${errorText}" />
<jsp:include page="footer.jsp" />
