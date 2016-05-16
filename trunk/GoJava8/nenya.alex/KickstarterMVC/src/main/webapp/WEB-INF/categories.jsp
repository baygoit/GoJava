<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Categories</title>
</head>
<body>
	<h3>${quote.name}</h3>
	<hr />
	<c:forEach var="category" items="${categories}">
		<p>
			<a href="<c:url value="/category/${category.id}"/>">${category.name}</a>
		</p>
	</c:forEach>

</body>
</html>