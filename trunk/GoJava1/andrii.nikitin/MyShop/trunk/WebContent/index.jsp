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
		<title>Categories of goods</title>
	</head>
	
	<body>
	
	<div class="jcode">
	<!--%if (request == null) out.print("requested is null"); %-->
	<!--%!Enumeration<String> collection; %-->
	<!--% collection = request.getAttributeNames(); %-->
	<!--%out.print(collection.nextElement()); %-->
	<!--%if (listTypes == null) out.print("list is null"); %-->
	<!--%if (listTypes!= null) out.print(listTypes.get(0)); %-->
	<%List<GoodType> list = new GoodCatalogImpl().getGoodTypesFromRoot(); %>
	
	<div class = "type_list_container">
		<ul>
			<%for (GoodType type: list) { %>
			<li>			
				     <span>
				     	<% String name = type.getName(); %>
				  	 	<% out.print(name); %>
				  	 </span> 
			  	 
			</li>			
			<%}%>
		</ul>
		</div>	
		
	</div>	
	
	<div class="frame1">
		<iframe name="frame1"></iframe>
		<a href="form.jsp" target="frame1" >Open some content</a>
	</div>
		
	</body>
</html>