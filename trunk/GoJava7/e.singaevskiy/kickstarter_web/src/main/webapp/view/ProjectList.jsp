<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${category.name} projects</title>
<%@ include file="html/style.html"%>
</head>
<body>
	<div class="root">
		<div class="box">
			<div class="boxCaption basecolor">${category.name} projects</div>
			<div class="boxContent">
				<c:forEach var="project" items="${projects}">
					<a href="./project?id=${project.id}"> ${project.name} </a>
					<br>
					Goal: <c:out value="${project.getGoalSum()}" />; 
					Balance: <c:out value="${project.getBalanceSum()}" />; 
					Days left: <c:out value="${project.daysLeft()}" />
					<br>
					<br>
				</c:forEach>

				<div class="controls basecolor"><jsp:include page="html/Back.html"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>