<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter project</title>
    </head>
    <body>
	    <b>Name:</b> <c:out value="${project.name}"/></br>
		<b>Description:</b> <c:out value="${project.description}"/>
    </body>
</html>
