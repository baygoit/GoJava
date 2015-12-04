<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects from selected category</title>
</head>
<body>

	<div class="container">
	
		<div class="title">Project detail information</div>		
		
		<fieldset>
		
			<legend class="legend">Selected project</legend>
			
			<div>
				
				<fieldset>
				
						<table>
	   			 
	       		   			<tr><td>Title : </td><td><c:out value="${project.getTitle()}"/></td></tr>
	       		   	
	       		  	 		<tr><td>Brief description : </td><td><c:out value="${project.getBriefDescription()}"/></td></tr>
	       		   	
	       		  	 		<tr><td>Required amount of $ : </td><td><c:out value="${project.getRequiredSum()}"/></td></tr>
	       		   	
	       		  	 		<tr><td>Collected amount of $ : </td><td><c:out value="${project.getCollectedSum()}"/></td></tr>
	       		  	 		
	       		  	 		<tr><td>Full description : </td><td><c:out value="${project.getFullDescription()}"/></td></tr>
	       		  	 		
	       		  	 		<tr><td>Video : </td><td><c:out value="${project.getVideoLink()}"/></td></tr>
	       		  	 		
	       		  	 			<tr><td>Questions : </td>
	       		  	 			
		       		  	 			<td>
		       		  	 				
		       		  	 				<c:forEach items="${questions}" var="question">
												
											<ul>
						   			 
						       		  	 		<li><c:out value="${question.getQuestion()}"/></li>
						       		   					       		   	
						       		   		</ul>
						  			 
										</c:forEach>
									</td>
									
								</tr>
	       		  	 		
	       		  	 		<tr><td><a href=\MyWebKickstarter\payment?id=${project.getUniqueID()}>Donate money</a></td></tr>
	       		  	 		
	       		  	 		<tr><td><a href=\MyWebKickstarter\ask?id=${project.getUniqueID()}>Ask question</a></td></tr>
    		   	
	       		   		</table>
	       		   	
	       		   	</fieldset>
			
			</div>
			
		</fieldset>
		
	</div>
	
</body>
</html>