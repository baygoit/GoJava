<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
</head>
<body>
<input type="button" value="previous page" onclick="self.location='${url}';" />
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
		<c:out value=" linkToVideo= ${detailedProject.linkToVideo}" />
	</h3>
	<input type="button" value="previous page" onclick="self.location='${url}';" />
</body>
</html>