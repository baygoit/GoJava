<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param value="Projects" name="title" />
</jsp:include>

<c:choose>
	<c:when test="${noProjectsFound == true}">
        Sorry. There are no projects in this category. 
        <br />
	</c:when>
	<c:otherwise>
		<h3>${categoryName}</h3>
		<ul>
			<c:forEach var="project" items="${projects}">
				<li><a href="project?id=${project.id}">${project.projectName}</a>
				</li>
			</c:forEach>
		</ul>
	</c:otherwise>
</c:choose>
<jsp:include page="footer.jsp" />
