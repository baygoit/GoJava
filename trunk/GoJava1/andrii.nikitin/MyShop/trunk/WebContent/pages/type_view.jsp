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

<title>Good info</title>
</head>
<body>
	<h2>Good Info</h2>
		<ul>
		<%
		session = request.getSession();
		String name = (String)session.getAttribute("name");
		int id = (Integer)session.getAttribute("id");		
		out.println("<p id = \"attributes\">");
		out.println("<b>Name: </b>" + name + "\n");
		out.println("<b>ID: </b>" + id + "\n");
		out.println("</p>");		
		%>
		</ul>
	<div id="hidden-part">
	</div>
	<a href="catalog.jsp">Back</a>
</body>
</html>