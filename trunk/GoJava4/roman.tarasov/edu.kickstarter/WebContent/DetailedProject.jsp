<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="UserMenu.jsp"></jsp:include>

<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Main</title>
</head>
<body\>
	<c:if test="${userName!=null}">
		<p>
			<jsp:include page="Donate.jsp"></jsp:include>
		<p>
	</c:if>
	<input type="button" value="projects page"
		onclick="self.location='/edu.kickstarter/projects';" />
	<h1>
		<c:out value=" ${detailedProject.name}" />
	</h1>

	<h3>
		<c:out value=" description= ${detailedProject.description}" />
	</h3>
	<h3>
		<c:out value=" goal= ${detailedProject.goal}" />
	</h3>
	<h3>
		<c:out value=" pledged= ${detailedProject.pledged}" />
	</h3>
	<h3>
		<c:out value=" daysToGo= ${detailedProject.daysToGo}" />
	</h3>
	<h3>
		<c:out value=" history= ${detailedProject.history}" />
	</h3>
	<h3>
		<c:out value=" link= ${detailedProject.linkToVideo}" />
	</h3>
	<%="Comments:"%>
	<br>
	<c:forEach var="comment" items="${comments}">
		<h3>
			<c:out value="${comment.comment}" />
		</h3>
	</c:forEach>
	<input type="button" value="projects page"
		onclick="self.location='/edu.kickstarter/projects';" />
</body>
</html>