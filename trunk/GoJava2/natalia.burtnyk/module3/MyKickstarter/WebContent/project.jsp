<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Project</title>
	</head>
	<body>
		<a href="/MyKickstarter/project?id=${project.name}">
		<c:out value="${project.name}"/></a><br/>
		<c:out value="${project.description}"/><br/>
		<c:out value="${project.history}"/><br/>
		<c:out value="${project.requiredAmount}"/><br/>
		<c:out value="${project.total}"/><br/>
		<c:out value="${project.days}"/><br/>
		<c:out value="${project.url}"/><br/>
	</body>
</html>