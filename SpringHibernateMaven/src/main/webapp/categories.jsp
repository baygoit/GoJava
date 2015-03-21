<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Kickstarter</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Categories</h2>	
	<table>
		<tr>
			<td>ID</td><td>NAME</td>
		</tr>
		<c:forEach items="${categories}" var="category">
			<tr>
			<td><a href="<c:url value='/delete-${category.id}-category' />">${category.id}</a></td>
			<td>${category.name}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newcategory' />">Add New Category</a>
</body>
</html>