<%@page import="goit.iavorskyi.learningUnit.Rating"%>
<%@page import="goit.iavorskyi.UIFacade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JavaHub</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="validator.js"></script>
</head>
<body>

	<div class="main">
		<div class="header">
			<h1>Header</h1>
		</div>
		<div class="body">
			<h1>Add article:</h1>
			<br>
			<form name="article" method="post" action="articlecontroller"
				onsubmit="return validateForm()">
				Your name:<br> <input type="text" name="author"><br>
				Header:<br> <input type="text" name="header"><br>
				Your article :<br>
				<textarea rows="4" cols="50" name="text"> </textarea>
				<br> <input type="submit" value="Submit article"><br>
			</form>
			<br>
			<h1>Articles:</h1>
			<br>

			
			
		</div>
		<div class="footer">
			<h1>Footer</h1>
		</div>
	</div>

</body>
</html>