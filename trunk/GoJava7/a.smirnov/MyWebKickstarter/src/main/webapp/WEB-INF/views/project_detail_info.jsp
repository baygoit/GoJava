<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project detail info</title>
</head>
<body>

	<div class="container">
		
		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
		
			<legend class="legend" style="text-align: center;">PROJECT DETAIL INFORMATION</legend>
			
			<div>
				
				<table>
	   			 
	       		   		<tr><td>Title : </td><td><c:out value="${project.name}"/></td></tr>
	       		   	
	       		  	 	<tr><td>Brief description : </td><td><c:out value="${project.shortDescription}"/></td></tr>
	       		   	
	       		  	 	<tr><td>Required amount of $ : </td><td><c:out value="${project.requiredSum}"/></td></tr>
	       		   	
	       		  	 	<tr><td>Collected amount of $ : </td><td><c:out value="${project.collectedSum}"/></td></tr>
	       		  	 		
	       		  	 	<tr><td>Full description : </td><td><c:out value="${project.fullDescription}"/></td></tr>
	       		  	 		
	       		  	 	<tr><td>Video : </td><td><c:out value="${project.linkOnVideo}"/></td></tr>
	       		  	 		
	       		  	 	<tr><td>Questions : </td>
	       		  	 	
	       		  	 	<tr>
	       		  	 			
		       		  		<td>
		       		  	 				
		       		  	 		<c:forEach items="${questions}" var="question">
												
									<ul>
						   		 
						       			<li><c:out value="${question.question}"/></li>
						       	   					       		   	
						    		</ul>
						  		 
								</c:forEach>
					
							</td>
									
						</tr>
	       		  	 		
	       		  	<tr><td><a href=payment?id=${project.id}>Donate money</a></td></tr>
	       		  	 		
	       			<tr><td><a href=ask?id=${project.id}>Ask question</a></td></tr>
    		   	
	        	</table>
	        				
			</div>
			
		</fieldset>
		
	</div>
	
</body>
</html>