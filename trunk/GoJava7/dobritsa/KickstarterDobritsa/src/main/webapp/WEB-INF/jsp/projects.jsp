<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Projects" />
</jsp:include>

<h1>${categoryName} </h1>

<ul>
	<c:forEach var="project" items="${requestScope.projects}">
		<li>
			<p>
				<a href="project?id=${project.id}">${project.name}</a>
				<br>Description: ${project.description} 
				<br>Goal: ${project.goal}
				<br>Pledged: ${project.pledged} 
				<br>Days: ${project.daysToGo}
			</p>
		</li>
	</c:forEach>
</ul>

<jsp:include page="footer.jsp" />