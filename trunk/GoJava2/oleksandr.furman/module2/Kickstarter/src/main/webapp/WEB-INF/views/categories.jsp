<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
		<div class="list-group">
			<a class="list-group-item active">Select category:</a>
			<c:forEach items="${categories}" var="category">
				<a href="projects?category=${category.id}" class="list-group-item"><c:out
						value="${category.name}" /></a>

			</c:forEach>
		</div>
	</div>
</body>
</html>