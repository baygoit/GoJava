<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<div class="title">Asking question page</div>

		<fieldset>

			<legend>FAQ fields</legend>

			<form action="payment" method="post">

				<div class="inputField">

					<label for="first-name" class="inputLabel">First name : </label> 
					
					<input name="first-name" type="text"></input>

				</div>
				
				<div class="inputField">

					<label for="creditCardNumber" class="inputLabel">Credit card number : </label> 
					
					<input name="creditCardNumber" type="text"></input>

				</div>

				<div class="inputField">

					<label for="donatingSum" class="inputLabel">donating sum : </label> 
					
					<input	name="donatingSum" type="text"></input>

				</div>

				<div class="inputField" id="submitField">

					<input id="submitButton" type="submit" value="Donate"></input>

				</div>

			</form>

		</fieldset>

	</div>

</body>
</html>