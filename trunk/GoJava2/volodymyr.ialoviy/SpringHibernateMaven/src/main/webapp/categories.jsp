<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kickstarter</title>
<style>
tr:first-child {font-weight: bold; background-color: #C6C9C4;}
h3 {color: #ff0000;}
</style>
</head>
<body>
	<h2>List of categories</h2>
	<h3><c:out value="${message}" /></h3>
	<table>
		<tr>
			<td>DELETE</td>
			<td>SHOW CATEGORY</td>
			<td>SHOW PROJECTS IN CATEGORY</td>
			<td>ADD NEW PROJECT</td>
		</tr>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td><a href="${ctx}/categories/${category.id}?delete">${category.name}(x)</a></td>
				<td><a href="${ctx}/categories/${category.id}">${category.name}</a></td>
				<td><a href="${ctx}/projects/${category.id}">${category.name}</a></td>
				<td><a href="${ctx}/projects?add">add new project for category # ${category.id}</a></td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="${ctx}/categories?add">Add new category</a></p>
</body>
</html>