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
	
		<div class="title">Projects from selection category</div>		
		
		<fieldset>
		
			<legend class="legend">All projects</legend>
			
			<div>
			
				<c:forEach items="${projects}" var="project">
				
				<fieldset>
				
						<table>
	   			 
	       		   			<tr><td>Title : </td><td><a href=\MyWebKickstarter\project?id=${project.getUniqueID()}><c:out value="${project.getTitle()}"/></a></td></tr>
	       		   	
	       		  	 		<tr><td>Brief description : </td><td><c:out value="${project.getBriefDescription()}"/></td></tr>
	       		   	
	       		  	 		<tr><td>Required amount of $ : </td><td><c:out value="${project.getRequiredSum()}"/></td></tr>
	       		   	
	       		  	 		<tr><td>Collected amount of $ : </td><td><c:out value="${project.getCollectedSum()}"/></td></tr>
	       		   	
	       		   		</table>
	       		   	
	       		   	</fieldset>
	  			 
				</c:forEach>
			
			</div>
			
		</fieldset>
		
	</div>
	
</body>
</html>