<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>
<body>
	<h2>Order form</h2>
	<form action="" name="" method="get">
		<h4>List of orders</h4>
		<table>
			<tr>
				<td>show order list</td>
				<td><input type="submit" name="getlist" value="Get list"></td>
			</tr>
		</table>
		<table>
			<tr>
				<th></th>
				<th>Order description</th>
				<th>Studio</th>
				<th>Customer</th>
				<th>Begin date</th>
				<th>End date</th>
			</tr>
		</table>
	</form>
	<br>
	<hr align="left" width="300" color="red">
	<form action="" name="" method="post">
		<table>
			<tr>
				<td>Add new order</td><td><input type="submit" name="add" value="Add"></td>
			</tr>	
			<tr>	
				<td>Edit order</td><td><input type="submit" name="edit" value="Edit"></td>
			</tr>	
			<tr>	
				<td>Show full info</td><td><input type="submit" name="showinfo" value="Show"></td>
			</tr>	
			<tr>
				<td>Delete order</td><td><input type="submit" name="delete" value="Delete"></td>
			</tr>
		</table>
	</form>
</body>
</html>