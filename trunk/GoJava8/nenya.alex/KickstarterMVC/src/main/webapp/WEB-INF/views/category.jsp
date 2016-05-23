<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Projects</title>
</head>
<body>
	<p>
		<a href="<c:url value="/"/>"> <spring:message code="category.back" /> </a>
	</p>

	<h3><spring:message code="category.choose" /></h3>
	<c:forEach var="project" items="${projects}">

		<p>
			<a
				href="<c:url value="/project/${project.id}"/>" >${project.name}</a>
		</p>
		<p>
			<b><spring:message code="project.name" />:</b> ${project.name}
		</p>
		<p>
			<b><spring:message code="project.description" />:</b> ${project.description}
		</p>
		<p>
			<b><spring:message code="project.neededAmount" />:</b> ${project.neededAmount}
		</p>
		<p>
			<b><spring:message code="project.availableAmount" />:</b> ${project.availableAmount}
		</p>
		<p>
			<b><spring:message code="project.remainingDays" />:</b> ${project.remainingDays}
		</p>
	</c:forEach>

</body>
</html>