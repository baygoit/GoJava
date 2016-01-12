<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="header.jsp">
	<jsp:param value="Category" name="title"/>
</jsp:include>
	<h1>Category:</h1>
	<p>
	${category.name}
	</p>
	<h1>Category projects:</h1>
	<ul>
		<c:forEach var="project" items="${category.projects}" >
			<li>
				<a href="project?id=${project.id}">${project.name}</a>
			</li>
		</c:forEach>
	</ul>
<jsp:include page="footer.jsp" />
