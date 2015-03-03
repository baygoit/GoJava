<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter project</title>
    </head>
    <body>
	    <c:out value="${project.title}"/></br>
	    <c:out value="${project.description}"/></br>
	    Project price: <c:out value="${project.projectPrice}"/> Collected: <c:out value="${project.collected}"/></br>
        Days left: <c:out value="${project.days}"/></br>
        <c:out value="${project.story}"/></br>
        Link: <c:out value="${project.link}"/></br>
        <a href="/sample/faq?project=${project.id}">Ask question</a></br>
        <a href="/sample/payment?project=${project.id}">Donate</a></br>
    </body>
</html>
