<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Category</title>
</head>
<body>
	<h2>
		Category:
		<c:out value="${model.category.name}" />
	</h2>
	<br>
	<ol>
		<c:forEach var="project" items="${model.projects}">
			<li><b><a href="project?id=${project.id}&action=view"><c:out
							value="${project.name}" /></a></b><br> 
					<b>Description: </b> <c:out value="${project.description}" /><br>
					<b>Cost: </b> <c:out value="${project.goalAmount}$" /><br>
					<b>Balance: </b> <c:out value="${project.pledgedAmount}$" /><br>
					<b>DeadLine: </b> <c:out value="${project.daysToGo}" /><br> <br></li>
		</c:forEach>
	</ol>
	<br>
	<br>
	<b><a href="home">Back</a></b>
</body>
</html>