<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donate</title>
<style>
.error {color: #ff0000;}
</style>
</head>

<body>
	<h2>Donate for project # <c:out value="${id}" />
	</h2>
	<table border="2" bordercolor="black" cellpadding="2">
		<tr>
			<td>invest project</td>
			<td><a href="${ctx}/donate/${id}/0?add">any amount</a></td>
			<td>thanks</td>
		</tr>
		<tr>
			<td>invest project</td>
			<td><a href="${ctx}/donate/${id}/1?add">1 dollar</a></td>
			<td>you get many thanks</td>
		</tr>
		<tr>
			<td>invest project</td>
			<td><a href="${ctx}/donate/${id}/5?add">5 dollars</a></td>
			<td>you get 1 month software license</td>
		</tr>
		<tr>
			<td>invest project</td>
			<td><a href="${ctx}/donate/${id}/10?add">10 dollars</a></td>
			<td>you get you link in our site</td>
		</tr>
	</table>
	<br />
	<p> Go back to	<a href="${ctx}/projects/${id}?show">project</a></p>
</body>
</html>