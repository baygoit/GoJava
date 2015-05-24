<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Kickstarter projects</title>
	</head>
	<body>
		<c:forEach items="${projects}" var="project">
			<a href="/MyKickstarter/project?id=${project.id}">
			<c:out value="${project.id}"/>
			<c:out value="${project.name}"/></a><br/>
			<c:out value="${project.description}"/>
			<br/>-----------------------------------
			<br/>
		</c:forEach>
	</body>
</html>