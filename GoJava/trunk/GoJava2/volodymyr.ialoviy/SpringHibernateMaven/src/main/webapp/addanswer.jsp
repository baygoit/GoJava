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

	<h1>Registration form</h1>
	<h4>Question: ${question.question}</h4>
	<form:form method="POST" modelAttribute="question">
	<div class="CSSTableGenerator" >
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
		</div>
	</form:form>
	<p>
		Go back to <a class="button" href="${ctx}/projects/${question.idProject}?show">project</a>
	</p>

</div>
</div>
</body>
</html>