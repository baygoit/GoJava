<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Kickstarter" />
</jsp:include>

<h1>Kickstarter</h1>

	<em>${quote.text}</em> <em>${quote.author}</em>

	<p>Categories:</p>

	<ul>
		<c:forEach var="category" items="${requestScope.categories}">
			<li><a href="projects?id=${category.categoryId}">${category.name}</a></li>
		</c:forEach>
	</ul>
	
	<p>Top 5 projects by pledged:</p>

	<ul>
		<c:forEach var="project" items="${requestScope.projects}">
			<li>$${project.pledged} - <a href="project?id=${project.projectId}">${project.name}</a></li>			
		</c:forEach>
	</ul>	

<jsp:include page="footer.jsp" />