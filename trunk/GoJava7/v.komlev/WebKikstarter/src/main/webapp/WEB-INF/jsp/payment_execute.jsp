<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Execute payment</title>
</head>
<body>

	<h2>PAYMENT</h2>
	<br>
	<form action="payment" method="post">
		
		<table>
			<tr>
				<td><label for="firstName">First name: </label></td>
				<td><input name="firstName" type="text"/></td>
			</tr>
			<tr>
				<td><label for="cardNumber">Card number: </label></td>
				<td><input name="cardNumber" type="text"/></td>
			</tr>
			<tr>
				<td><label for="donatingSum">Enter the amount of donations: </label></td>
				<td><input name="donatingSum" type="text"/></td>
			</tr>
		</table>
		<table>
			<c:forEach items="${projectRewards}" var="reward">
				<tr>
					<td>You have already donated ${reward.getDonatingSum()} : ${reward.getDescription()}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Execute payment"/></td>
			</tr>
		</table>
	</form>
</body>
</html>