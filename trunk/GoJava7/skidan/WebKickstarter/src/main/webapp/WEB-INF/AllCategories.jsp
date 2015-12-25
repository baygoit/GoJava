<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.kickstarter.model.Quote"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AllCategories</title>
</head>
<h1>Kickstarter Category Selection</h1>
<br>
<br>
<body>

	<%
		Quote quote = (Quote) request.getAttribute("quote");
	%>

	<div id=3>
		<%=quote.getQuoteText()%><br>
		<%=quote.getAuthor()%><br><br><br>

       <h2>Categories</h2>
		<c:forEach items="${categoryList}" var="category">
			<b><a href=SelectedCategoryProjectsServlet?categoryTitle=${category.getTitle()}><c:out
					value="${category.getTitle()}" /></a></b>
		</c:forEach><br><br>
		
		<h3>Top rated projects</h3>
       <c:forEach items="${projectList}" var="project">
      <b><a href=SingleProjectServlet?projectId=${project.getId()}> 
      <c:out value="${project.getTitle()}"/></a></b><br><br>
      Sum already gained : <c:out value="${project.getGainedSum()}"/><br><br>
       Required Sum :<c:out value="${project.getRequiredSum()}"/><br><br>
       </c:forEach>


	</div>
</body>
</html>