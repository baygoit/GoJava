<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Project</title>
</head>
<body>
	<h2>Project ${model.name}</h2>
	<br>
	<b>Description: </b>
	<c:out value="${model.description}" />
	<br>
	<b>Goal: </b>
	<c:out value="${model.goalAmount}$" />
	<br>
	<b>Pledged: </b>
	<c:out value="${model.pledgedAmount}$" />
	<br>
	<b>Days Left: </b>
	<c:out value="${model.daysToGo}" />
	<br>
	<b>Video: </b>
	<a href="<c:out value="${model.link}"/>"><c:out
			value="${model.link}" /></a>
	<br>
	<br>
	<b>Events: </b>
	<c:choose>
		<c:when test="${!empty model.events}">
			<br>
			<ol>
				<c:forEach var="event" items="${model.events}">
					<li><b>Event Date: </b> <c:out value="${event.date}" /><br>
						<b>Description: </b> <c:out value="${event.description}" /><br>
					</li>
				</c:forEach>
			</ol>
		</c:when>
		<c:otherwise>
			<br>
		</c:otherwise>
	</c:choose>
	<br>
	<b>FAQ: </b>
	<c:choose>
		<c:when test="${!empty model.faq}">
			<br>
			<ol>
				<c:forEach var="faq" items="${model.faq}">
					<li><b>Question: </b> <c:out value="${faq.question}" /><br>
						<b>Answer: </b> <c:out value="${faq.answer}" /><br></li>
				</c:forEach>
			</ol>
		</c:when>
		<c:otherwise>
			<br>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${param.action == 'addQuestion'}">
			<form action="addQuestion" method="POST">
				Enter your Question: <input type="text" name="question" size="20px">
				<br>
				<input type="hidden" name="id" value="${param.id}" /> <input
					type="hidden" name="action" value="addQuestion" /> <input
					type="submit" value="Confirm">
			</form>
			<a href="project?id=${model.id}&action=view">Cancel</a>
		</c:when>
		<c:otherwise>
			<b><a href="project?id=${model.id}&action=addQuestion">Add
					new question</a></b>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<c:choose>
		<c:when test="${param.action == 'view'}">
			<b><a href="project?id=${model.id}&action=donate">Donate</a></b>
		</c:when>
		<c:when test="${param.action == 'donate'}">
			<ol>
				<li><a href="pledge?id=${model.id}&amount=0&done=no"><b>Donate
							any amount</b></a></li>
				<c:forEach var="reward" items="${model.rewardOptions}">
					<li><a
						href="pledge?id=${model.id}&amount=${reward.amount}&done=no">
							<b>Donate: $ <c:out
									value="${reward.amount} - ${reward.description}" /></b>
					</a></li>
				</c:forEach>
			</ol>
		</c:when>
	</c:choose>
	<br>
	<b><a href="category?id=${model.categoryId}">Back</a></b>
</body>
</html>