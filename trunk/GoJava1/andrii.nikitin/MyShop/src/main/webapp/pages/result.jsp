<%@ page language="java" contentType="text/html; charset=UTF-8"
	
				
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/stylesheet1.css" rel="stylesheet" type="text/css" />

<title>Update</title>
</head>
<body>	
		
			<%
		session = request.getSession();
		String message = (String)session.getAttribute("message");	
		out.println("<i>" + message + "</i>");
			%>
	<a href="edit.html">Back</a>
</body>
</html>