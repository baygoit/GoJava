<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<c:set var="title" scope="request">
	<spring:message code="question.askQuestion" />
</c:set>
<jsp:include page="header.jsp"/>
<iframe src="<c:url value="/quote" />" width="600" height="40" frameborder="no"></iframe>
		<hr/>
		<p>
			<spring:message code="question.project" />: <label class="subheader">${project.name}</label>
		</p>
		<p>
			<label class="subheader"><spring:message code="question.askQuestion" /></label>
		<p/>
		<form:form method="post" commandName="question" accept-charset="utf-8">
			<form:textarea maxlength="1024" path="request" cols="50" rows="2" />
			<br />
			<form:errors path="request" cssClass="error" element="div"/>
			<input class="button" type="submit" value="<spring:message code="question.send" />" />
		</form:form>
		<spring:message code="question.questionsAnswers" />:<br/>
		<hr/>
		<c:forEach var="currentQuestion" items="${project.questions}">
			<spring:message code="question.questionLabel" />: <label class="question">${currentQuestion.request}</label>
			<br/>
			<c:if test="${null != currentQuestion.reply}"> 
			<spring:message code="question.answerLabel" />: <label class="answer">${currentQuestion.reply}</label>
			<br/>
			</c:if>
 		</c:forEach>
 		<br/>
		<a href="<c:url value="/project/${project.id}" />"><spring:message code="common.returnLink" /></a>
<jsp:include page="footer.jsp"/>
		
