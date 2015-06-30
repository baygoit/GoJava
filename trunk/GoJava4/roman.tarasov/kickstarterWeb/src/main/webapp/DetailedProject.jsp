<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<ul class="user-menu js-user-menu">
<li class="logged-out-link"><a href="login?project=${detailedProject.ID}&category=${category}">Log in</a></li>
</ul>

<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Main</title>
</head>
<body>

	<c:if test="${user!=null}">
		<p>
			<jsp:include page="UserMenu.jsp"></jsp:include>
		<p>
	</c:if>
	<c:if test="${user==null}">
	<h1>
		<c:out value="Login for donate, invest or comment" />
	</h1>
	</c:if> 
	<br>
	<input type="button" value="projects page"
		onclick="self.location='projects?category=${category}';" />
	<h1>
		<c:out value=" ${detailedProject.name}" />
	</h1>

	<p>
		<c:out value=" description= ${detailedProject.description}" />
		<br>
		<c:out value=" goal= ${detailedProject.goal}" />
		<br>
		<c:out value=" pledged= ${detailedProject.pledged}" />
		<br>
		<c:out value=" daysToGo= ${detailedProject.daysToGo}" />
		<br>
		<c:out value=" history= ${detailedProject.history}" />
	</p>

	<p>
		link : <a href="${detailedProject.linkToVideo}">${detailedProject.linkToVideo}</a>
	</p>

	<h3>
		<c:out value="Comments:" />
	</h3>

	<c:if test="${comments.size()>0}">
		<c:forEach var="i" begin="0" end="${comments.size()-1}">
			<c:out value="${listUsersNames.get(i)} : ${comments.get(i).comment}" />
			<br />
		</c:forEach>

	</c:if>

	<input type="button" value="projects page"
		onclick="self.location='projects?category=${category}';" />
</body>
</html>