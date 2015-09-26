<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Kickstarter</title>
</head>
<body>
	<h2>
		<c:out value="${quote.text}" />
	</h2>
	<h2>
		<c:out value="${quote.author}" />
	</h2>
	<br>
	<h2>Categories:</h2>
	<ol>
		<c:forEach var="category" items="${categories}">
			<li><a href="${requestScope['javax.servlet.forward.request_uri']}/category/${category.id}"><c:out
						value="${category.name}" /></a></li>
		</c:forEach>
	</ol>
</body>
</html>
