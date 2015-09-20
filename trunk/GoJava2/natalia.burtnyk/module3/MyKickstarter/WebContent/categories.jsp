<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Kickstarter</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
		<body>
			<c:out value="${quote}"/>
			<br/> 
			*** *** *** *** *** ***
			<br/> 
			<c:forEach items="${categories}" var="category">
			<a href="/MyKickstarter/projects?category=${category.id}">
			<c:out value="${category.id}. ${category.name}"/>
			</a>
			<br/>
			</c:forEach>
		</body>
	</html>