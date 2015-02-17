<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="view.css" media="all" />
<script type="text/javascript" src="view.js"></script>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Delete</title>
	</head>
	
	<body id="main_body">
		<div id="form_container">
		   <h1><a>Delete</a></h1>
		   <form id="deleteform" class="appnitro" method="post" action="actors">
		       <div class="form_description">
		           <h2>Delete</h2>
		       </div>
		       <ul>
		           <li id="li_1">
		               <label class="description" for="element_1">Heroes</label>
		               <span>
		                   <c:forEach items="${requestScope.gamers}" var="gamerItem"> 
		                   <input id="element_1_1" name="${gamerItem.getName()}" class="element checkbox" type="checkbox" unchecked /> 
		                   <label class="choice" for="element_1_1"><c:out value="${gamerItem.getName()}"/></label>
		                   </c:forEach>
		               </span>
		               <p class="guidelines" id="guide_1"> 
		                   <small>Select characters to delete</small>
		               </p>
		           </li>
		
		           <li class="buttons"><input type="hidden" name="delete" value="yes"/> 
		               <input id="saveForm" class="button_text"	type="submit" name="submit" value="Submit" />
		           </li>
		       </ul>
		   </form>
		</div>
	</body>
</html>