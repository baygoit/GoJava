<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Category</title>
</head>
<body>
	<h2>
		Category:
		<c:out value="${category.name}" />
	</h2>
	<br>
	<ol>
		<c:forEach var="project" items="${projects}">
			<li><b><a href="${requestScope['javax.servlet.forward.request_uri']}/project/${project.id}/view"><c:out
							value="${project.name}" /></a></b> <br> <b>Description: </b> <c:out
					value="${project.description}" /> <br> <b>Goal: </b> <c:out
					value="${project.amountRequired}$" /> <br> <b>Pledged: </b> <c:out
					value="${project.amountCollected}$" /> <br> <b>Days Left: </b> <c:out
					value="${project.daysToGo}" /> <br> <br></li>
		</c:forEach>
	</ol>
	<br>
	<br>
	<b><a href="/KickstarterWEB/main">Back</a></b>
</body>
</html>