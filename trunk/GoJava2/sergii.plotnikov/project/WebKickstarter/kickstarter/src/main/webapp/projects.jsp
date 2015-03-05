<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter projects</title>
    </head>
    <body>
        You have chosen <c:out value="${category.title}"/></br>
	    <c:forEach items="${projects}" var="project"> 
		  	<a href="/kickstarter/project?project=${project.id}"><c:out value="${project.title}"/></a></br>
		  	<c:out value="${project.description}"/>
		  	</br>
		  	Project price: <c:out value="${project.projectPrice}"/> Collected: <c:out value="${project.collected}"/>
		  	</br>
		  	Days left: <c:out value="${project.days}"/>
            </br>
		  	------------------------------
		  	</br>
		</c:forEach>
    </body>
</html>
