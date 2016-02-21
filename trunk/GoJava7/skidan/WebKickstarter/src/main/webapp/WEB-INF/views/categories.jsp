<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.kickstarter.model.Quote"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>

.nav{
color: #FFFFCC;
}
.category {
	border: 10px solid transparent;
}
.category:hover {
	border-color: #f1f1f1;
}
.carousel-inner img {
	-webkit-filter: grayscale(90%);
	filter: grayscale(90%); /* make all photos black and white */
	width: 100%; /* Set width to 100% */
	margin: auto;
}
.carousel-caption h3 {
	color: #fff !important;
}
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}
</style>
<title>AllCategories</title>
</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/">Kickstarter</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="/WebKickstarter">Home</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>Logged in as: <sec:authentication property="name" /></li>
			<li><sec:authentication property="authorities" /></li>
			<li><a href="logout"><span
					class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</ul>
	</div>
	</nav>
	<%
		Quote quote = (Quote) request.getAttribute("quote");
	%>
	<div class="well well-sm">
		<strong> <%=quote.getQuote()%><br> <%=quote.getAuthor()%><br>
		</strong>
	</div>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="<c:url value="/resources/css/technology.jpg" />"
					alt="New York" width="1200" height="700">
				<div class="carousel-caption">
					<h3>Newest technologies</h3>
					<p>Find them here at one place.</p>
				</div>
			</div>

			<div class="item">
				<img src="<c:url value="/resources/css/education.jpg" />"
					alt="Chicago" width="1200" height="700">
				<div class="carousel-caption">
					<h3>Education</h3>
					<p>Most interesting educational projects are here!</p>
				</div>
			</div>

			<div class="item">
				<img src="<c:url value="/resources/css/sport.jpg" />" width="1200"
					height="700">
				<div class="carousel-caption">
					<h3>All of the sport</h3>
					<p>Find out the newest sport ideas!</p>
				</div>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>


	<div class="container">
		<div class="page-header">
			<h1>Categories</h1>
		</div>
	</div>

	<div class="container text-center">
		<div class="row">
			<c:forEach items="${categoryList}" var="category">
				<div class="col-sm-4">
					<p>
						<strong>${category.getTitle()}</strong>
					</p>
					<br> <a href=project/list?categoryId=${category.getId()}>
						<img
						src="<c:url value="/resources/css/${category.getId()}.jpg" />"
						class="img-circle category" alt="Random Name" width="210"
						height="210">
					</a>
				</div>
			</c:forEach>
		</div>
	</div>












	<!--  	<h3>Top rated projects</h3>
       <c:forEach items="${projectList}" var="project">
      <b><a href=SingleProjectServlet?projectId=${project.getId()}> 
      <c:out value="${project.getTitle()}"/></a></b><br><br>
      Sum already gained : <c:out value="${project.getGainedSum()}"/><br><br>
       Required Sum :<c:out value="${project.getRequiredSum()}"/><br><br>
       </c:forEach> 
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
       
       -->


</body>
</html>