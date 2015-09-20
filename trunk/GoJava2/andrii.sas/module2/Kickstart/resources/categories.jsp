<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter</title>
    </head>
    <body>
        <c:forEach items="${categories}" var="category">
            <a href="/Kickstarter/projects?category=${category.id}"><c:out value="${category.name}"></c:out></a>
        </c:forEach>
    </body>
</html>