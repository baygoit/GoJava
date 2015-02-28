<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter categories</title>
    </head>
    <body>
	    <c:forEach items="${categories}" var="category"> 
		  	<a href="/servlets/projects?category=${category.id}"><c:out value="${category.name}"/></a>
		</c:forEach>
    </body>
</html>
