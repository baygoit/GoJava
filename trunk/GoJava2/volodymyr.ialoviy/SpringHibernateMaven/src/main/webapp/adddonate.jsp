<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question registration form</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>

<body>
	<h2>Donation form</h2>
	<p>message : ${success}</p>
	<form:form method="POST" modelAttribute="donation">
		<table>
			<tr>
				<td><label for="amount">Your amount: </label></td>
				<td><form:input path="amount" id="amount" value="${amount}" /></td>
				<td><form:errors path="amount" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="idProject">For id project: </label></td>
				<td><form:input path="idProject" id="idProject" value="${idProject}" /></td>
				<td><form:errors path="idProject" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="name">Your name: </label></td>
				<td><form:input path="name" id="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="mail">Your email: </label></td>
				<td><form:input path="mail" id="mail" /></td>
				<td><form:errors path="mail" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="card">Your credit card: </label></td>
				<td><form:input path="card" id="card" /></td>
				<td><form:errors path="card" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="add answer" /></td>
			</tr>
		</table>
	</form:form>


	<p>
		Go back to <a href="${ctx}/projects/${project}?show">project #
			${project}</a>
	</p>
</body>
</html>