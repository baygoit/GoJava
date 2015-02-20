<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ua.com.goit.gojava1.grigorius0sol.RCCreateModel.ViewParts" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Constructor</title>
</head>
<body>
 
 
 <%
 ViewParts category = new ViewParts();
  
 for(String name: category.getDetailsCat()){
 %> 
		<ul><%out.print(name);%>
			<%for(String detail: category.getDetails(name)){ 
			%>
				<li>
					<input type="radio" name="name" value=/>
					<% out.print(detail);%>
			
				</li>
			<%}%>	
		</ul>
		
<%  
 }
 %>
 
</body>
</html>