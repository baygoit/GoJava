<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order data</title>
</head>
<body>
	<form action="" name="" method="post">
		<input type="hidden" name="orderId" value="">
		<table>
			<tr>
				<th>New order form</th>
			</tr>
			<tr>
				<td>Order info</td><td><input type="text" name="ordinfo" value=""></td>
			</tr>
		</table>
	</form>
	<br>
	<form action="AllocateServlet" name="" method="post">
		<table>
			<tr>
				<td>Add customer</td><td><input type="submit" name="addcust" value="Add"></td>
			</tr>
			<tr>
				<td>Add Photo studio</td><td><input type="submit" name="addstud" value="Add"></td>
			</tr>
			<tr>
				<td>Add Photography</td><td><input type="submit" name="addphot" value="Add"></td>
			</tr>
			<tr>
				<td>Add Schedule</td><td><input type="submit" name="addsched" value="Add"></td>
			</tr>
		</table>		
	</form>
</body>
</html>