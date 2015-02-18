<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="ua.com.goit.gojava.andriidnikitin.model.GoodType" %>
<%@ page import="java.util.Enumeration"  %>
<%@ page import="ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!List<GoodType> listTypes;%>
<!-- % listTypes =(List<GoodType>)request.getAttribute("types"); % -->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="css/stylesheet1.css" rel="stylesheet" type="text/css"/>		
		<title>Catalog of goods</title>
	</head>
	
	<body>
	
	<!-- 
	<div class="frame1">
		<iframe name="frame1"></iframe>
		<a href="form.jsp" target="frame1">Open some content</a>
	</div>
	 -->
	
	<div class="type-list-container">
		<iframe name=category-frame height="1000" width="400"> </iframe>
	</div>	
	
	<form name="form1" action="print-categories" method="get" target="category-frame">
			<input type="submit" value="show categories">
	</form>

	</body>
</html>