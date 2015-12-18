<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects in selected category</title>
</head>
<body>

	<div class="container">	
		
		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
		
			<legend class="legend" style="text-align: center;">ALL PROJECTS IN SELECTED CATEGORY</legend>
			
			<div>
			
				<c:forEach items="${projects}" var="project">
				
				<fieldset style="border: 0">
				
						<table>
	   			 
	       		   			<tr><td>Title : </td><td><a href=project?id=${project.uniqueID}><c:out value="${project.title}"/></a></td></tr>
	       		   	
	       		  	 		<tr><td>Brief description : </td><td><c:out value="${project.briefDescription}"/></td></tr>
	       		   	
	       		  	 		<tr><td>Required amount : </td><td><c:out value="${project.requiredSum}"/> USD</td></tr>
	       		   	
	       		  	 		<tr><td>Collected amount : </td><td><c:out value="${project.collectedSum}"/> USD</td></tr>
	       		   	
	       		   		</table>
	       		   	
	       		   	</fieldset>
	  			 
				</c:forEach>
			
			</div>
			
		</fieldset>
		
	</div>
	
</body>
</html>