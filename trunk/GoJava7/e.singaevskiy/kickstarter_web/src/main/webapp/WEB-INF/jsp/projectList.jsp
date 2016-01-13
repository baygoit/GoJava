<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="project" items="${projects}">
	<a href="./project?id=${project.id}"> ${project.name} </a>
	<br>
					Goal: ${project.getGoalSum()}; 
					Balance: ${project.getBalanceSum()}; 
					Days left: ${project.daysLeft()}
	<br>
	<br>
</c:forEach>
