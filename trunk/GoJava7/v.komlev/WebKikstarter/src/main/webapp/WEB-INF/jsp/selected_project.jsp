<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selected project</title>
</head>
<body>

	<h3><a href="category?category_id=${category.getId()}">Back to list projects</a></h3>
	<h3><a href="categories">Change category</a></h3>
	<h2>${project.name}</h2>
	<br>
	<table border="1">
		<tr>
			<td><i>Description</i></td>
			<td>${project.getGenerelDescription()}</td>
		</tr>
		<tr>
			<td><i>Full description</i></td>
			<td>${project.getFullDescription()}</td>
		</tr>
		<tr>
			<td><i>Required sum</i></td>
			<td>${project.getRequiredSum()}</td>
		</tr>
		<tr>
			<td><i>Collected sum</i></td>
			<td>${project.getCollectedSum()}</td>
		</tr>
		<tr>
			<td><i>Days to go</i></td>
			<td>${project.getEndOfDays()}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="${project.getVideoLink()}">Video link on project</a></td>
		</tr>
	</table>
	<br>
	<a href="payment?id=${project.getId()}">Donate money</a>
</body>
</html>