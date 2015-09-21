<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Kickstarter</title>
</head>
<body>
<h1>Daily quote: <c:out value="${quote}" /></h1>

<c:forEach var="category" items="${categories}" varStatus="loop">
    <li>
    <a href="category/<c:out value="${loop.index + 1}"/>">
    <c:out value="${category}"/></a></li> 
</c:forEach>
</body>
</html>