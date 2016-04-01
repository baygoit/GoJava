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
	<p>Description: ${project.requiredBudget}</p>
	<p>Description: ${project.gatheredBudget}</p>
	<p>Description: ${project.daysLeft}</p>
	<p>Description: ${project.history}</p>
	<p>Description: ${project.url}</p>
</body>
</html>