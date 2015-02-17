<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="view.css" media="all" />
<script type="text/javascript" src="view.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body id="main_body" >
	<div id="form_container">
		<h1><a>Edit</a></h1>
		<form id="edit" class="appnitro"  method="post" action="actors">
					<div class="form_description">
			<h2>Edit</h2>
		</div>						
			<ul >
					<li id="li_1" >
		<label class="description" for="element_1">Name </label>
		<div>
			<input id="element_1" name="element_1" class="element text large" type="text" maxlength="255" value=""/> 
		</div><p class="guidelines" id="guide_1"><small>One word. Only alphanumeric symbols allowed.</small></p> 
		</li>		<li id="li_2" >
		<label class="description" for="element_2">Skills </label>
		<div>
			<textarea id="element_2" name="element_2" class="element textarea medium"></textarea> 
		</div><p class="guidelines" id="guide_2"><small>One skill per line. Only alphanumeric symbols allowed</small></p> 
		</li>
					<li class="buttons">
			    <input type="hidden" name="form_id" value="972345" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
		</li>
			</ul>
		</form>	
	</div>
	</body>
</html>