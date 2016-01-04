<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>
<body>

	<div class="container">

		<fieldset style="width: 600px; font-family: Arial; font-size: 14px"> 
		
			<legend style="text-align: center">RANDOM QUOTE</legend>
			
			<div style="text-align: center">"${quoteText}"</div>

			<div style="text-align: right; font-style: italic;"> (c) ${quoteAuthor}</div>
			
		</fieldset>

		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">

			<legend style="text-align: center">ALL CATEGORIES</legend>
			
			<div>
			
				<ol>
				
					<c:forEach items="${categories}" var="category">
					
						<li><a href=category?id=${category.id}><c:out value="${category.getName()}"/></a></li>
						
					</c:forEach>
					
				</ol>
				
			</div>

		</fieldset>
		
		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
		
			<legend style="text-align: center">TOP 10 CATEGORIES</legend>
			
				<div>
				
					<ol>
						
						<c:forEach var="map" items="${top10Categories}">
						
   							<li> ${map[0]} : overall amount of pledges = ${map[1]} </li>
   							
						</c:forEach>
					
					</ol>
			
				</div>
		
		</fieldset>
		
	</div>

</body>
</html>