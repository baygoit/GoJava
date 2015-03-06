<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter</title>
</head>
	<body>

		<c:forEach var="i" items="${categories}">
		   Item <c:out value="${i}"/><p>
		</c:forEach>
	
	</body>
</html>
