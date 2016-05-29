<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<c:set var="title" value="${project.name}" scope="request"/>
<jsp:include page="header.jsp"/>
		<iframe src="<c:url value="/quote" />" width="600" height="40" frameborder="no"></iframe>
		<hr/>
		<p>
			<spring:message code="project.project" />: <label class="subheader">${project.name}</label>
		</p>
		<table>
			<tr>
				<td><spring:message code="project.category" />:</td>
				<td>${project.category.name}</td>
			</tr>
			<tr>
				<td><spring:message code="project.description" />:</td>
				<td>${project.description}</td>
			</tr>
			<tr>
				<td><spring:message code="project.requiredSum" />:</td>
				<td>${project.requiredSum}</td>
			</tr>
			<tr>
				<td><spring:message code="project.collectedSum" />:</td>
				<td>${project.collectedSum}</td>
			</tr>
			<tr>
				<td><spring:message code="project.daysLeft" />:</td>
				<td>${project.remainingDays}</td>
			</tr>
			<tr>
				<td><spring:message code="project.history" />:</td>
				<td>${project.history}</td>
			</tr>
			<tr>
				<td><spring:message code="project.video" />:</td>
				<td><a href="${project.videoUrl}">${project.videoUrl}</a></td>
			</tr>
		</table>
		<br/>
		<a href="<c:url value="/investment/${project.id}" />"><spring:message code="project.investLink" /></a>
		<br/><br/>
		<hr/>
		<spring:message code="project.questionsAnswers" />:<br/>
		<a href="<c:url value="/question/${project.id}" />"><spring:message code="project.questionLink" /></a>
		<br/><br/>
		<c:forEach var="question" items="${project.questions}">
			<spring:message code="project.questionLabel" />: <label class="question">${question.request}</label>
			<br/>
			<c:if test="${null != question.reply}"> 
			<spring:message code="project.answerLabel" />: <label class="answer">${question.reply}</label>
			<br/>
			</c:if>
 		</c:forEach>
 		<hr/>
		<br/><br/>
		<a href="<c:url value="/category/${project.category.id}" />"><spring:message code="common.returnLink" /></a>
<jsp:include page="footer.jsp"/>
