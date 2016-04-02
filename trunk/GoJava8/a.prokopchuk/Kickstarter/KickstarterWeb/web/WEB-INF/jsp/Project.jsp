<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="css/style.css" type="text/css" rel="stylesheet">
	<title>Project</title>
</head>
<body>
<div class="header">
	<div class="logo" >
		<a href="categories">
			<img src="images/logo.jpg">
		</a>
	</div>
</div>
	<h2>${project.name}</h2>
	<p>Description: ${project.description}</p>
	<p>Required budget: ${project.requiredBudget}</p>
	<p>Gathered budget: ${project.gatheredBudget}</p>
	<p>Days left: ${project.daysLeft}</p>
	<p>History: ${project.history}</p>
	<p>Video URL: ${project.url}</p>
</body>
</html>