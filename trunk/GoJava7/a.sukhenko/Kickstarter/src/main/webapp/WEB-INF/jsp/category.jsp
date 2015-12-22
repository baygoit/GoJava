<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="header.jsp">
	<jsp:param value="${category.categoryName}" name="title"/>
</jsp:include>
	<h3>${category.categoryName}</h3>
	<ul>
		<c:forEach var="category" items="${categories}" >
			<li>
				<a href="project?name=${category.}">${project.projectName}</a>
			</li>
		</c:forEach>
	</ul>
<jsp:include page="footer.jsp" />
