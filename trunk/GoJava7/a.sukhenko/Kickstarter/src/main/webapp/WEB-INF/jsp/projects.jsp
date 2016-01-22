<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="header.jsp">
	<jsp:param value="Projects" name="title"/>
</jsp:include>
		<h3>${categoryName}</h3>
	<ul>
		<c:forEach var="project" items="${projects}" >
			<li>
				<a href="project?id=${project.id}">${project.projectName}</a>
			</li>
		</c:forEach>
	</ul>
<jsp:include page="footer.jsp" />
