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
<title>Result</title>
</head>
<body>
	<h2>Result of operation</h2>
		<%
		session = request.getSession();
		Good good = (Good)session.getAttribute("newGood");		
		GoodType type = (GoodType)session.getAttribute("newType");
		String report = (String)session.getAttribute("message");
		out.println("<p><i>" + report + "</i></p>");	
		String typeOfReport = (String)session.getAttribute("typeOfReport");
		if ("good".equals(typeOfReport)){			
			out.println("<b>Name   </b>" + good.getName());	
			GoodType typeOfGood = good.getType();
			out.println("<b>Type   </b>" + typeOfGood.getName());
			out.println("<b>ID   </b>" + good.getId());	
		}	
		if ("goodType".equals(typeOfReport)){			
			out.println("<b>Name   </b>" + type.getName());	
			GoodType parent = type.getParent();
			out.println("<b>Type   </b>" + parent.getName());
			out.println("<b>ID   </b>" + type.getId());	
		}	
		%>
	<a href="index.html">Back</a>
</body>
</html>