<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

	<h2>${category.name}</h2>
	<ul>
		<c:forEach var="project" items="${projects}">
			<li><a href="project?projectId=${project.id}">${project.name}</a></li>
		</c:forEach>
	</ul>

<jsp:include page="footer.jsp" />