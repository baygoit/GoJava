<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asking question</title>
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
				
				<% if (request.getAttribute("questionError") != null) {%>
					<li class="error"> Question error.</li>
				<% } %>
							
			</ul>
		
		</fieldset>
	
	
	<%
	
		}
		
	 %>

		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">

			<legend style="text-align: center;">ASK QUESTION</legend>

			<form action="ask" method="post">

				<table>
					
					<tr>
		
						<td><label for="first-name" class="inputLabel">First name : </label></td>
							
						<td><input name="first-name" type="text"></input></td>
		
					</tr>
					<tr>
						
						<td><label for="question" class="inputLabel">Question : </label></td>
						
						<td><input	name="question" type="text"></input></td>
	
					</tr>
					<tr>
						
						<td colspan="2"><input id="submitButton" type="submit" value="Ask question"></input><td>
					
					</tr>
					
				</table>

			</form>

		</fieldset>

	</div>

</body>
</html>