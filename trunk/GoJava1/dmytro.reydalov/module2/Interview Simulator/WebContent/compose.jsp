<%@page import="ua.com.goit.gojava2.solo307.interview.*"%>
<%@page import="java.io.File"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Compose your categories</title>
	</head bgcolor="Azure" >
	<body>
		<p> Compose your categories </p>
		<%  Interview interview = new Interview();
		interview.createCategories();
		for(Category category: interview.getCategories()){%>
		<form action="Composer" method="Post">	
		<p><input type="checkbox" name="category" value="<%= category.getName()%>"> <%= " " + category.getName()%></p>
		<% } %>
		<p><input type="submit" value="Submit"></p>
		</form>
		<a href="menu.jsp">Вернуться на главную</a> <br>	
	</body>
	</html>