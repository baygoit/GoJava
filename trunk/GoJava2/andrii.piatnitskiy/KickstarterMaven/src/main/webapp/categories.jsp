<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<c:forEach var="category" items="${categories}">
		<p>
			<a href="/KickstarterWeb/projects?category=${category.id}">${category.name}</a>
		</p>
	</c:forEach>
</body>
</html>