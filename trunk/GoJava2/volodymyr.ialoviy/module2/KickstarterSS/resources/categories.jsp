<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter</title>
</head>
	<body>

		<c:forEach items="${categories}" var="category">
		   <a href="/sample/projects?category${category.categoryID}"><c:out value="${category.categoryName}"/></a><p>
		</c:forEach>
	
	</body>
</html>
