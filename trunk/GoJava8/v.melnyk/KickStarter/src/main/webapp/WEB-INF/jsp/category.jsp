<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Projects" scope="request"/>
<%@include file='header.jsp'%>
		Category: <label class="subheader">${category.name}</label><br/><br/>
		Project list:<br/>
		<hr/>
		<ul>
		<c:forEach var="project" items="${projects}">
			<li><a href="?page=project&id=${project.id}">${project.title}</a> (collected: ${project.collectedSum} / ${project.requiredSum}), ${project.daysLeft} days left: ${project.briefDescription}</li>
		</c:forEach>
		</ul>
		<a href='?page=categories'>Return</a>
<%@include file='footer.jsp'%>
