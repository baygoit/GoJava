<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>
<body>

	<div class="container">
	
		<div class="title">Main kickstarter page</div>
	
		<fieldset>
		
			<legend>Generated random quote</legend>
			
			<div><%= request.getAttribute("quoteText") %></div>
			
			<div>(c) <%= request.getAttribute("quoteAuthor") %></div>
			
		</fieldset>
		
		<fieldset>
		
			<legend>All categories</legend>
			
			<div>
			
				 <ol>
			
					<c:forEach items="${categories}" var="category">
	   			 
	       		   	<li><a href=\MyWebKickstarter\category?id=${category.getUniqueID()}><c:out value="${category.getName()}"/></a></li>  
	  			 
					</c:forEach>
				
				</ol>
			
			</div>
			
		</fieldset>
		
	</div>
	
</body>
</html>