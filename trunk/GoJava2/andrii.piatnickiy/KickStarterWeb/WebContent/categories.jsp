<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<c:set var="myName" value="Alex" />
	<h1>${myName}</h1>
	<c:forEach var="category" items="${categories}">
		<p>value="${category.getName()}"</p>
		111
	</c:forEach>
	666
</body>
</html>