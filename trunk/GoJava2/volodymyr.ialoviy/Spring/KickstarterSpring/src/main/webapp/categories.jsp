<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter categories</title>
</head>
	<body>

		<c:forEach items="${categories}" var="category">
		   <p><a href="projects?category=${category.IdCategory}"><c:out value="${category.nameCategory}"/></a></p>
		</c:forEach>
	
	</body>
</html>
