<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="title" scope="request">
	<spring:message code="category.projects" />
</c:set>
<jsp:include page="header.jsp"/>
		<iframe src="<c:url value="/quote" />" width="600" height="40" frameborder="no"></iframe>
		<hr/>
		<p>
			<spring:message code="category.category" />: <label class="subheader">${category.name}</label>
			<br/>
		</p>
		<ul>
		<c:forEach var="project" items="${category.projects}">
			<li><a href="<c:url value="/project/${project.id}" />">${project.name}</a> (<spring:message code="category.collected" />: ${project.collectedSum} / ${project.requiredSum}), ${project.remainingDays} <spring:message code="category.daysLeft" />: ${project.description}</li>
		</c:forEach>
		</ul>
		<a href="<c:url value="/" />"><spring:message code="common.returnLink" /></a>
<jsp:include page="footer.jsp"/>
