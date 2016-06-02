<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Projects" scope="request"/>
<%@include file='header.jsp'%>
		
		<ul>
		<c:forEach var="project" items="${category.projects}">
			<li><a href="<c:url value="/project/${project.id}" />">${project.name}</a>
			<br>Gathered budget:  ${project.gatheredBudget} 
			<br>Required budget: ${project.requiredSum}
			<br>Days to go: ${project.remainingDays}
			<br>Description: ${project.description}</li>
		</c:forEach>
		</ul>
		<a href='/kickstarter'>Return</a>
<%@include file='footer.jsp'%>