<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Kickstarter</title>
</head>
<body>
	<h2>
		<c:out value="${model.quote.text}" />
	</h2>
	<h2>
		<c:out value="${model.quote.author}" />
	</h2>
	<br>
	<h2>Categories:</h2>
	<ol>
		<c:forEach var="category" items="${model.categories}">
			<li><a href="category?id=${category.id}"><c:out
						value="${category.name}" /></a></li>
		</c:forEach>
	</ol>
</body>
</html>
