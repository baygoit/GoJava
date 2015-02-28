<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter project</title>
    </head>
    <body>
   		Project:</br>
	    <c:out value="${project.name}"/></br>
		<c:out value="${project.description}"/>
    </body>
</html>
