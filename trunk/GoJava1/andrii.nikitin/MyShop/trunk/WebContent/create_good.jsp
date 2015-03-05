<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.andriidnikitin.model.*,
			ua.com.goit.gojava.andriidnikitin.model.util.*,
			ua.com.goit.gojava.andriidnikitin.service.*,
			java.util.Enumeration,
			ua.com.goit.gojava.andriidnikitin.servlets.*,
			java.util.List"
				
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/stylesheet1.css" rel="stylesheet" type="text/css" />
<title>Create good</title>
</head>
<body>
	<h2>Create</h2>
	<p>Type name of category you want to expand with new good</p>
	<form action="act-good" method="post">
		<span>Name</span>		
		<input type="text" name="good">
		<span>Category</span>
		<input type="text" name="categoryName">
		<input type="hidden" name="action" value="create">
		<input type="submit">  
		
	</form>
	<a href="index.html">Back</a>
</body>
</html>