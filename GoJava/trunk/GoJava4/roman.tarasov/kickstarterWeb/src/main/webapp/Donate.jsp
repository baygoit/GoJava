<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Donate</h2>
	<input type="button" value="project page"
		onclick="self.location='DetailedProject?project=${project}&category=${category}';" />

	<c:if test="${user==null}">
		<p>
			<c:out value=" only for registered user" />
		<p>
	</c:if>
	<c:if test="${user!=null}">
		<p>
			<c:out value=" ${user.name }" />
		<p>
		<h1>Enter the payment details </h1>
		<form action="donate?project=${project}&category=${category}" method="post">
			Login :(bankir) <input type="text" name="bankLogin"> <br> Card
			Number: (777)<input type="text" name="bankCardNumber"> <br>
			Pay : <input type="text" name="bankPay"> <br> <input
				type="submit" value="Submit">
		</form>

	</c:if>
	<c:if test="${balanceBefore!=null&&balanceAfter!=null}">
		<c:out value=" balance before operation: ${balanceBefore}" />
		<c:out value=" balance after operation: ${balanceAfter}" />
	</c:if>
</body>
</html>