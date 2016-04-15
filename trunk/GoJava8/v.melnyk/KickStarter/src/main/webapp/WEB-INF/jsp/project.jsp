<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="${project.title}" scope="request"/>
<%@include file='header.jsp'%>
		Project: <label class="subheader">${project.title}</label>
		<hr/>
		<table>
			<tr>
				<td>Description:</td>
				<td>${project.briefDescription}</td>
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
				<td>${project.daysLeft}</td>
			</tr>
			<tr>
				<td>History:</td>
				<td>${project.fullDescription}</td>
			</tr>
			<tr>
				<td>Video:</td>
				<td><a href="${project.videoLink}">${project.videoLink}</a></td>
			</tr>
		</table>
		Questions and answers:<hr/>
		<c:forEach var="question" items="${faqList}">
			Q: <label class="question">${faq.question}</label><br/>
			<c:if test="${null != faq.answer}">
				A: <label class="answer">${faq.answer}</label><br/>
			</c:if>
 		</c:forEach>
 		<hr/>
		Ask a question<br/>
		<form name='add_question' method='POST' action='' accept-charset='utf-8'>
			<input type='hidden' name='requested_action' value='ADD_QUESTION'/>
			<input type='hidden' name='project_id' value='${project.id}'/>
			<textarea maxlength='1024' name='question_request' cols='50' rows='2'></textarea><br/>
			<input class='button' type='submit' value='Send'>
		</form>
		<br/>
		<a href='?page=investment&project_id=${project.id}'>Invest in the project</a><br/><br/>
		<a href='?page=category&id=${category.id}'>Return</a>
<%@include file='footer.jsp'%>
