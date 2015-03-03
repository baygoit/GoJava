<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter categories</title>
    </head>
    <body>
	    <c:forEach items="${categories}" var="category"> 
		  	<a href="/sample/projects?category=${category.id}"><c:out value="${category.title}"/></a>
		</c:forEach>
    </body>
</html>
