<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category registration form</title>
<style><%@include file='/defoult.css' %></style>
</head>

<body>
<div class="center" >
<div class="center2" >

	<h2>Registration form</h2>
	<form:form method="POST" modelAttribute="category">
	<div class="CSSTableGenerator" >
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
			<tr>
				<td colspan="3"><input type="submit" value="Register"/></td>
			</tr>
		</table>
		</div>
	</form:form>
	<br/>
	<p>Go back to <a href="${ctx}/categories">list of all categories</a></p>
	
</div>
</div>
</body>
</html>