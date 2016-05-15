<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="${project.name}" scope="request"/>
<jsp:include page="header.jsp"/>
		Project: <label class="subheader">${project.name}</label>
		<hr/>
		<table>
			<tr>
				<td>Category:</td>
				<td>${project.category.name}</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>${project.description}</td>
			</tr>
			<tr>
				<td>Required sum:</td>
				<td>${project.requiredSum}</td>
			</tr>
			<tr>
				<td>Collected sum:</td>
				<td>${project.collectedSum}</td>
			</tr>
			<tr>
				<td>Days left to start:</td>
				<td>${project.remainingDays}</td>
			</tr>
			<tr>
				<td>History:</td>
				<td>${project.history}</td>
			</tr>
			<tr>
				<td>Video:</td>
				<td><a href="${project.videoUrl}">${project.videoUrl}</a></td>
			</tr>
		</table>
		Questions and answers:<hr/>
		<c:forEach var="question" items="${project.questions}">
			Q: <label class="question">${question.request}</label>
			<br/>
			<c:if test="${null != question.reply}"> 
			A: <label class="answer">${question.reply}</label>
			<br/>
			</c:if>
 		</c:forEach>
 		<hr/>
		Ask a question<br/>
		<form name="add_question" method="POST" action="<c:url value="/project/${project.id}/addQuestion" />" accept-charset="utf-8">
			<input type="hidden" name="action" value="add_question"/>
			<input type="hidden" name="project_id" value="${project.id}"/>
			<textarea maxlength="1024" name="question_request" cols="50" rows="2"></textarea>
			<br/>
			<input class="button" type="submit" value="Send">
		</form>
		<br/>
		<a href="<c:url value="/investment/${project.id}" />">Invest in the project</a>
		<br/><br/>
		<a href="<c:url value="/category/${project.category.id}" />">Return</a>
<jsp:include page="footer.jsp"/>
