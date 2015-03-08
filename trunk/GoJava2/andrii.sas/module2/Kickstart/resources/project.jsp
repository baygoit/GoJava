<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Kickstarter</title>
</head>
	<body>
		<c:out value="${project.name}"></c:out><br>
		<c:out value="${project.description}"></c:out><br>
		<c:out value="${project.moneyNeed}"></c:out><br>
		<c:out value="${project.moneyHas}"></c:out><br>
		<c:out value="${project.daysLeft}"></c:out><br>
		<c:out value="${project.history}"></c:out><br>
		<c:out value="${project.videoLink}"></c:out><br>
		<c:out value="${project.question}"></c:out><br><br>
		<a href="/Kickstarter/projects?category=${project.categoryId}">Return</a>
	</body>
</html>