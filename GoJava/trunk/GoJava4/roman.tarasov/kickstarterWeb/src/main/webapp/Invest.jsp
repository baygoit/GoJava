<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Invest</h2>
	<input type="button" value="project page"
		onclick="self.location='DetailedProject?project=${project}&category=${category}';" />

	<c:if test="${user==null}">
		<p>
			<c:out value=" only for registered user" />
		<p>
	</c:if>

	<c:if test="${user!=null}">
		<br>
		<c:out value=" investment options: " />
		<br>
		<c:forEach items="${detailedProject.investmentOptions}"
			varStatus="loop">
			<a
				href="invest?project=${project}&category=${category}&option=${loop.index}">
				<c:out value="${detailedProject.investmentOptions[loop.index]}" /><br>
			</a>
		</c:forEach>

		<p>
			<c:out value="user: ${user.name }" />
		<p>
			<c:if test="${correctOption!=null}">
				<c:out value=" selected investment option : ${detailedProject.investmentOptions[correctOption]}" />
				<h1>Enter the payment details</h1>
				<form
					action="invest?project=${project}&category=${category}&&option=${correctOption}"
					method="post">
					Login :(bankir) <input type="text" name="bankLogin"> <br>
					Card Number: (777)<input type="text" name="bankCardNumber">
					Pay : <input type="text" name="bankPay" value="${detailedProject.amount[correctOption]}">
					<br> <input type="submit" value="Submit">
				</form>
			</c:if>
	</c:if>
	<c:if test="${balanceBefore!=null&&balanceAfter!=null}">
		<c:out value=" balance before operation: ${balanceBefore}" />
		<c:out value=" balance after operation: ${balanceAfter}" />
	</c:if>
</body>
</html>