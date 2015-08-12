<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Kickstarter</title>

<body>
<h2><c:out value="${model.welcomeMessage}"/></h2>
<ol>
    <c:forEach items="${model.categories}" var="category">
        <li><a href="category?id=${category.key}"><c:out value="${category.value}"/></a></li>
    </c:forEach>
</ol>
</body>
</html>
