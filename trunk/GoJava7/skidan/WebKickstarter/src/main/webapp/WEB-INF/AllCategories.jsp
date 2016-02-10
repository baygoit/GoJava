<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.kickstarter.model.Quote"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style>
#quote {
	font-family: fantasy;
	font-weight: bold;
	border: 2px;
	color: black;
	font-size: 30px;
}

#b {
	background-image: url("http://oboi.tululu.org/o/30/76866/prew.jpg");
}

#ref {
	font-family: fantasy;
	font-weight: bold;
	color: black;
	font-size: 30px;
	margin: 4px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>AllCategories</title>
</head>

<table>
<tr>
 <td align="left"><spring:message code="user.logged" /></td>
 <td align="left"><sec:authentication property="name" />
 <sec:authentication property="authorities" /></td>
</tr>
</table>
<a href="logout">
    <input type="button" value="Logout"/>
</a>
<h1 id="header">Kickstarter Category Selection</h1>

<br>
<br>
<body id="b">

	<%
		Quote quote = (Quote) request.getAttribute("quote");
	%>

	<div id="quote">
		<%=quote.getQuote()%><br>
		<%=quote.getAuthor()%><br>
	</div>
	<h2>Categories</h2>
	<ul>
		<c:forEach items="${categoryList}" var="category">
			<li><b><a id="ref"
					href=project/list?categoryId=${category.getId()}> <c:out
							value="${category.getTitle()}" /></a></b></li>
		</c:forEach>

	</ul>













	<!--  	<h3>Top rated projects</h3>
       <c:forEach items="${projectList}" var="project">
      <b><a href=SingleProjectServlet?projectId=${project.getId()}> 
      <c:out value="${project.getTitle()}"/></a></b><br><br>
      Sum already gained : <c:out value="${project.getGainedSum()}"/><br><br>
       Required Sum :<c:out value="${project.getRequiredSum()}"/><br><br>
       </c:forEach> -->


</body>
</html>