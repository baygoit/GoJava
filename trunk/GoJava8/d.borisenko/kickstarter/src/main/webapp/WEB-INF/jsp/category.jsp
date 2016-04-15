<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Projects" scope="request"/>
<jsp:include page="header.jsp"/>
		Category: <label class="subheader">${category.name}</label><br/><br/>
		Project list:<br/>
		<hr/>
		<ul>
		<c:forEach var="project" items="${projects}">
			<li><a href="?page=project&id=${project.id}">${project.name}</a> (collected: ${project.collectedSum} / ${project.requiredSum}), ${project.daysLeft} days left: ${project.description}</li>
		</c:forEach>
		</ul>
		<a href="?page=categories">Return</a>
<jsp:include page="footer.jsp"/>
