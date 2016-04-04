<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Categories</title>
</head>
<body>
	<h3>${quote.name}</h3>
	<hr/>
	<h4>Choose one of the items bellow</h4>
	<c:forEach var="category" items="${categories}" varStatus="varStatus">
		<p>
			${varStatus.count}. <a
				href="projectsServlet?categoryName=${category.name}">${category.name}</a>
		</p>
	</c:forEach>

</body>
</html>