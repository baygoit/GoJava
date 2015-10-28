<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter categories</title>
</head>
	<body>

		<c:forEach items="${categories}" var="category">
		   <p><a href="/sample/projects?category=${category.categoryID}"><c:out value="${category.categoryName}"/></a></p>
		</c:forEach>
	
	</body>
</html>
