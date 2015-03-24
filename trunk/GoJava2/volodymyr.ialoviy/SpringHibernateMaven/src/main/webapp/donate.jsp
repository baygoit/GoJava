<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donate</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>

<body>
	<h2>Donate for project # <c:out value="${idproject}" />
	</h2>
	<table border="2" bordercolor="black" cellpadding="2">
		<tr>
			<td>invest project</td>
			<td><a href="donate-0-amount-${idproject}-project">any amount</a></td>
			<td>thanks</td>
		</tr>
		<tr>
			<td>invest project</td>
			<td><a href="donatesuccess?amount=1&project=${idproject}">1 dollar</a></td>
			<td>you get many thanks</td>
		</tr>
		<tr>
			<td>invest project</td>
			<td><a href="donate-5-amount-${idproject}-project">5 dollars</a></td>
			<td>you get 1 month software license</td>
		</tr>
		<tr>
			<td>invest project</td>
			<td><a href="donate-10-amount-${idproject}-project">10 dollars</a></td>
			<td>you get you link in our site</td>
		</tr>
	</table>
	<br />
	<br /> Go back to
	<a href="<c:url value='project?project=${idproject}' />">project</a>
</body>
</html>