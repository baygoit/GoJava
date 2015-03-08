<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter projects</title>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<table align="center" border="2">
 	 		<tr>
 	 			<td>name</td>
 	 			<td>description</td>
 	 			<td>goal</td>
 	 			<td>pledged</td>
 	 			<td>days left</td>
	 		</tr>
	    	<c:forEach items="${projects}" var="project"> 
	  	 		<tr>
	  	 			<td>
	  	 			<a href="project?id=${project.id}" class="btn btn-info" role="button"><c:out value="${project.name}"/></a>
	  	 				
	  	 			</td>
	  	 			<td>
	  	 				<c:out value="${project.description}"/>
	  	 			</td>
	  	 			<td>
	  	 				<c:out value="${project.goal}"/>
	  	 			</td>
	  	 			<td>
	  	 				<c:out value="${project.pledged}"/>
	  	 			</td>
	  	 			<td>
	  	 				<c:out value="${project.daysLeft}"/>
	  	 			</td>
	  	 		</tr>
			</c:forEach>
	  	</table>  	
    </body>
</html>
