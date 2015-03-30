<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project registration form</title>
<style>
.error {color: #ff0000;}
</style>
</head>

<body>
	<h2>Registration form</h2>
	<form:form method="POST" modelAttribute="project">
		<table>
			<tr>
				<td><label for="name">Name: </label></td>
				<td><form:input path="name" id="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="name">ShortDescription: </label></td>
				<td><form:input path="shortDescription" id="shortDescription" /></td>
				<td><form:errors path="shortDescription" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="fullDescription">FullDescription: </label></td>
				<td><form:input path="fullDescription" id="fullDescription" /></td>
				<td><form:errors path="fullDescription" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="foto">Foto: </label></td>
				<td><form:input path="foto" id="foto" /></td>
				<td><form:errors path="foto" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="link">Link: </label></td>
				<td><form:input path="link" id="link" /></td>
				<td><form:errors path="link" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="howMuchNeeded">HowMuchNeeded: </label></td>
				<td><form:input path="howMuchNeeded" id="howMuchNeeded" /></td>
				<td><form:errors path="howMuchNeeded" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="dateClose">DateClose: </label></td>
				<td><form:input path="dateClose" id="dateClose" /></td>
				<td><form:errors path="dateClose" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="idCategory">Id Category: </label></td>
				<td><form:input path="idCategory" id="idCategory" value="${id}" /></td>
				<td><form:errors path="idCategory" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="howMuchCollected">HowMuchCollected: </label></td>
				<td><form:input path="howMuchCollected" id="howMuchCollected" /></td>
				<td><form:errors path="howMuchCollected" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="howMuchRemaining">HowMuchRemaining: </label></td>
				<td><form:input path="howMuchRemaining" id="howMuchRemaining" /></td>
				<td><form:errors path="howMuchRemaining" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
	<p>Go back to <a href="${ctx}/categories">list of all categories</a></p>
</body>
</html>