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
	<div class="questions">
		<c:forEach var="question" items="${questions}">
			<p class="question">${question.question}</p>
				<c:forEach var="answer" items="${question.answers}">
					<p class="answer">${answer.answer}</p>
				</c:forEach>
		</c:forEach>
	</div>
	<form class="form-horizontal" action="" method="POST">
		<div class="form-group col-sm-7">
			<input required type="text" class="form-control" id="inputQuestion"
				name="question" placeholder="Enter your question">
			<input id="projectId" type="hidden" name="projectId"
				value="${project.id}" />
		</div>
		<div class="form-group col-sm-7">
			<button type="submit" class="btn btn-default">Ask</button>
		</div>
	</form>



<jsp:include page="footer.jsp" />