<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kickstarter</title>

<style>
tr:first-child {font-weight: bold; background-color: #C6C9C4;}
</style>
</head>
<body>
	<h2>List of categories</h2>
	<table border="2" bordercolor="black" cellpadding="2">
		<tr>
			<td>ID CATEGORY</td>
			<td>NAME CATEGORY</td>
		</tr>
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
			</tr>
	</table>
	<br />
	<p>Return to all <a href="${ctx}/categories">categories</a></p>
</body>
</html>