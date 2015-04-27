<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question registration form</title>
<style><%@include file='/defoult.css' %></style>
</head>

<body>
<div class="center" >
<div class="center2" >

	<h2>Registration form</h2>
	<form:form method="POST" modelAttribute="question">
	<div class="CSSTableGenerator" >
		<table>
			<tr>
				<td><label for="question">Your question: </label></td>
				<td><form:input path="question" id="question" /></td>
				<td><form:errors path="question" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="idProject">Id Project: </label></td>
				<td><form:input path="idProject" id="idProject" value="${id}" /></td>
				<td><form:errors path="idProject" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="add question" /></td>
			</tr>
		</table>
		</div>
	</form:form>
	<p>
		Go back to <a href="${ctx}/projects/${id}?show">project</a>
	</p>

</div>
</div>
</body>
</html>