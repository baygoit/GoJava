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
	<h2>Registration form</h2>
	<h4>Question: ${question.question}</h4>
	<form:form method="POST" modelAttribute="question">
		<table>
			<tr>
				<td><label for="answer">Your answer: </label></td>
				<td><form:input path="answer" id="answer" /></td>
				<td><form:errors path="answer" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="add answer" /></td>
			</tr>
		</table>
	</form:form>
	<p>
		Go back to <a href="${ctx}/projects/${question.idProject}?show">project</a>
	</p>
</body>
</html>