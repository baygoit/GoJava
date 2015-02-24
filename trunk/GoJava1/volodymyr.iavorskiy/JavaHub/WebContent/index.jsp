<%@page import="goit.iavorskyi.learningUnit.Rating"%>
<%@page import="goit.iavorskyi.UIFacade"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JavaHub</title>
<link rel="stylesheet" type="text/css" href="Style.css">
<script src="Validator.js"></script>
</head>
<body>
	<div class="main">
		<div>
			<ul class="mainMenu">
				<li><a href="#" class="button">Link 1</a></li>
				<li><a href="#" class="button">Link 2</a></li>
				<li><a href="#" class="button">Link 3</a></li>
				<li><a href="#" class="button">Link 4</a></li>
			</ul>
			<hr />
		</div>
		
		<!-- 
		<form name="article" method="post" action="test">
			Your name:<br>
			<input type="text" name="author"><br>
			Your article :<br>
			<input type="text" name="text"><br><br>
			<input type="submit" value="Submit"><br>
		</form>
		<br>
		 -->
		 
		<form name="article" method="post" action="creator" onsubmit="return validateForm()">
		Your name:<br>
			<input type="text" name="author"><br>
			Your article :<br>
		<textarea rows="4" cols="50" name="text"> </textarea> <br>
		<input type="submit" value="Submit article"><br>
		</form>
		<br>
		
		<div>
		<%
		List<String> article = UIFacade.getArticle();
		%>
		<%= article.get(0) %>
		<br>
		<% for (int i = 1; i < article.size(); i++) { %>
			<%= article.get(i) %>
		<%}%>
		</div>
		
		<br>
		<form name="getArticle" method="get" action="">
		Author:<br>
			<input type="text" name="author"><br>
			Article :<br>
		<textarea rows="4" cols="50" name="text"> </textarea> <br>
		<input type="submit" value="Get article">
		<input type="submit" value="Update article"><br>
		</form>
		<br>
		<br>
		<form name="test" method="get" action="">
			<input type="submit" value="some button">
		</form>
	</div>
</body>
</html>