<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>

	<div class="container">
	
	<% 
		if (request.getAttribute("errors") != null) {
		
	%>
		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
			<legend>Errors</legend>
			
			<ul>
			
				<% if (request.getAttribute("nameError") != null) {%>
					<li class="error"> Name error.</li>
				<% } %>
				
				<% if (request.getAttribute("creditCardError") != null) {%>
					<li class="error"> Credit card number invalid.</li>
				<% } %>
				
				<% if (request.getAttribute("donatingSumError") != null) {%>
					<li class="error"> Donating sum invalid.</li>
				<% } %>
			
			</ul>
		
		</fieldset>
	
	
	<%
	
		}
		
	 %>

		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">

			<legend style="text-align: center;">PAYMENT</legend>

			<form action="payment" method="post">

				<table>
					<tr>
						<td><label for="first-name" class="inputLabel">First name : </label></td>

						<td><input name="first-name" type="text"></input></td>
					</tr>

					<tr>
						<td><label for="creditCardNumber" class="inputLabel">Credit	card number : </label></td>

						<td><input name="creditCardNumber" type="text"></input></td>
					</tr>
				</table>
				
				<fieldset style="border: 0">
					<table>
						<c:forEach items="${projectRewards}" var="reward">
							<tr>
								<td colspan="2">If you donate ${reward.getDonatingSum()} USD : ${reward.getDescription()}</td>
							</tr>
						</c:forEach>

						<tr>
							<td><label for="donatingSum" class="inputLabel">Please enter pledge amount : </label></td>
	
							<td><input name="donatingSum" type="text"></input></td>
						</tr>

						<tr>
							<td colspan="2"><input id="submitButton" type="submit" value="Execute payment"></input></td>
						</tr>
						
					</table>
					
				</fieldset>
				
			</form>
			
		</fieldset>
		
	</div>
</body>
</html>