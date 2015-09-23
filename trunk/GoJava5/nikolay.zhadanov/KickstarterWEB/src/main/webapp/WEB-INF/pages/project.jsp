<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Project</title>
</head>
<body>
	<h2>Project ${project.name}</h2>
	<br>
	<b>Description: </b>
	<c:out value="${project.description}" />
	<br>
	<b>Goal: </b>
	<c:out value="${project.amountRequired}$" />
	<br>
	<b>Pledged: </b>
	<c:out value="${project.amountCollected}$" />
	<br>
	<b>Days Left: </b>
	<c:out value="${project.daysToGo}" />
	<br>
	<b>Video: </b>
	<c:choose>
		<c:when test="${!empty project.link}">
			<a href="<c:out value="${project.link}"/>"><c:out
					value="${project.link}" /></a>
		</c:when>
		<c:otherwise>
			<a>-/-</a>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<b>Events: </b>
	<c:choose>
		<c:when test="${!empty events}">
			<br>
			<ol>
				<c:forEach var="event" items="${events}">
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
		<c:when test="${!empty faqs}">
			<br>
			<ol>
				<c:forEach var="faq" items="${faqs}">
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
		<c:when test="${isQuestion}">
			<form action="addQuestion" method="POST">
				Enter your Question: <input type="text" name="question" size="20px">
				<input type="hidden" name="redirect"
					value="${requestScope['javax.servlet.forward.request_uri']}" /> <br>
				<input type="submit" value="Confirm" />
			</form>
			<a
				href="/KickstarterWEB/main/category/${category.id}/project/${project.id}/view">Cancel</a>
		</c:when>
		<c:otherwise>
			<b><a href="question">Add new question</a></b>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<c:choose>
		<c:when test="${isDonate}">
			<ol>
				<li><a href="donate/0"><b>Donate any amount</b></a></li>
				<c:forEach var="reward" items="${rewards}">
					<li><a href="donate/${reward.id}"> <b>Donate: $ <c:out
									value="${reward.amount} - ${reward.description}" /></b>
					</a></li>
				</c:forEach>
			</ol>
		</c:when>
		<c:otherwise>
			<b><a href="donate">Donate</a></b>
		</c:otherwise>
	</c:choose>
	<br>
	<b><a href="/KickstarterWEB/main/category/${category.id}">Back</a></b>
</body>
</html>