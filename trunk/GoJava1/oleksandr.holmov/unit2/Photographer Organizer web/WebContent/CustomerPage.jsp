<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer data</title>
</head>
<body>
		<form action="<c:url value="/editcust"/>" method="post">
		<input type="hidden" name="customerId" value="${customer.customerId}">
		<table>
			<tr>
				<th><h3>Customer form</h3></th>
			</tr>
			<tr>
				<td>Customer name:</td><td><input type="text" name="custname" value="${customer.name}"></td>
			</tr>
			<tr>
				<td>Customer address:</td><td><input type="text" name="custaddress" value="${customer.address}"></td>
			</tr>
			<tr>
				<td>Customer phone:</td><td><input type="text" name="custphone" value="${customer.phone}"></td>
			</tr>
			<tr>
				<td>Customer info:</td><td><input type="text" name="custinfo" value="${customer.info}"></td>
			</tr>
		</table>
		<hr align="left" width="275" color="red">
		<table>
			<tr>
				<td><input type="submit" name="ok" value="OK"></td>
				<td><input type="submit" name="cancel" value="Cancel"></td>
				<td><input type="reset" name="reset" value="Clear"></td>
			</tr>
		</table>	
	</form>
</body>
</html>