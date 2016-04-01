<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="css/style.css" type="text/css" rel="stylesheet">
	<title>Categories</title>
</head>
<body>
<div class="header">
	<div class="logo" >
		<a href="categories">
			<img src="images/logo.jpg">
		</a>
	</div>
</div>
	<h2>${category.name}</h2>
	<ul>
		<c:forEach var="project" items="${projects}">
			<li><a href="project?projectIdId=${project.id}">${project.name}</a></li>
		</c:forEach>
	</ul>
</body>
</html>