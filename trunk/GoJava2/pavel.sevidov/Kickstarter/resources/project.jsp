<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter project</title>
    </head>
    <body>
   		Project:</br>
	    Name: <c:out value="${project.name}"/></br>
		Description: <c:out value="${project.description}"/></br>
		Collected already <c:out value="${project.collected}"/> of <c:out value="${project.amount}"/></br>
		Left days: <c:out value="${project.days}"/></br>
		History: <c:out value="${project.details.history}"/></br>
		Video: <a href="${project.details.video}"/>Funny cats ;-)</a>
    </body>
</html>
