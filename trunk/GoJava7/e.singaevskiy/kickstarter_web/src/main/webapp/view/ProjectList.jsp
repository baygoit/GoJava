<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="components/Top.jsp"><jsp:param name="title"
		value="${category.name} projects" /></jsp:include>

<jsp:include page="components/Menu.jsp"/>

<c:forEach var="project" items="${projects}">
	<a href="./project?id=${project.id}"> ${project.name} </a>
	<br>
					Goal: ${project.getGoalSum()}; 
					Balance: ${project.getBalanceSum()}; 
					Days left: ${project.daysLeft()}
	<br>
	<br>
</c:forEach>

<jsp:include page="components/Bottom" />