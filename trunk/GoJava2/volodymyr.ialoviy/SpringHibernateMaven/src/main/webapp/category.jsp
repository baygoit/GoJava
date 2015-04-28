<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kickstarter</title>
<style><%@include file='/defoult.css' %></style>
</head>
<body>
<div class="center" >
<div class="center2" >

	<h1>Category</h1>
	
	<div class="CSSTableGenerator" >
		<table>
			<tr>
				<td>ID CATEGORY</td>
				<td>NAME CATEGORY</td>
			</tr>
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
			</tr>
		</table>
	</div>
	
	<p>Return to all <a class="button" href="${ctx}/categories">categories</a></p>

</div>
</div>
</body>
</html>