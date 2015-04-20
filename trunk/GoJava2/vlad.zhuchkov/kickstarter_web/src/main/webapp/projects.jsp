<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter projects</title>
    </head>
    <body>
		<table border="1">
 	 		<tr>
 	 			<td>name</td>
 	 			<td>description</td>
	 		</tr>
	    	<c:forEach items="${projects}" var="project"> 
	  	 		<tr>
	  	 			<td>
	  	 				<a href="/kickstarter/project/${project.id}"><c:out value="${project.name}"/></a>
	  	 			</td>
	  	 			<td>
	  	 				<c:out value="${project.description}"/>
	  	 			</td>
	  	 		</tr>
			</c:forEach>
	  	</table>	  	
	  	<a href="/kickstarter/deleteCategory/${id}"><c:out value="Delete"/></a>
    </body>
</html>