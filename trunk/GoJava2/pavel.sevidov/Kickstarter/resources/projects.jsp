<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter projects</title>
    </head>
    <body>
	    <c:forEach items="${projects}" var="project"> 
		  	<a href="/servlets/project?id=${project.id}"><c:out value="${project.name}"/></a></br>
		  	<c:out value="${project.description}"/>
		  	</br>
		  	------------------------------
		  	</br>
		</c:forEach>
    </body>
</html>
