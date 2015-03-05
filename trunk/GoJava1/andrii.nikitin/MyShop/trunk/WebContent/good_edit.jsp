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
<title>Edit</title>
</head>
<body>
	<h2>Edit good</h2>
		<form action="act-good" method="post">
		<%		
		Good good = (Good)session.getAttribute("good");
		out.println("<input type=\"hidden\" name=\"good\" value=\"" + good.getId() + "\">");
		out.println("<br>");
		out.println("<b>Old name  </b>" + good.getName());	
		out.println("<input type=\"checkbox\" name=\"changeName\">    Change");
		out.println("<input type=\"text\" name=\"newName\">");
		out.println("<br>");
		GoodType type = good.getType();
		out.println("<b>Old type  </b>" + type.getName());		
		out.println("<input type=\"checkbox\" name=\"changeType\">    Change");
		out.println("<input type=\"text\" name=\"newType\">");
		out.println("<br>");
		out.println("<input type=\"hidden\" name=\"action\" value=\"update\">");
		out.println("<input type=\"hidden\" name=\"step\" value=\"execute\">");
		out.println("<input type=\"submit\">");	
		out.println("<br>");
		%>
		</form>
	<div id="hidden-part">	
	</div>
	<a href="catalog.jsp">Back</a>
</body>
</html>