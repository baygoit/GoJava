<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter categories</title>
</head>
	<body>

		<c:forEach items="${categories}" var="category">
		   <p><a href="projects?category=${category.idCategory}"><c:out value="${category.nameCategory}"/>00</a></p>
		</c:forEach>
	
	<p><a href="#"/>00</a></p>
	
	</body>
</html>
