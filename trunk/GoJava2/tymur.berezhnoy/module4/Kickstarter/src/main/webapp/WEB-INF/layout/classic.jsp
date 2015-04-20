<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
	
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title><tiles:getAsString name="title" /></title>
	
	<!-- Bootstrap core CSS -->
	<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
	<link href="http://getbootstrap.com/examples/sticky-footer-navbar/sticky-footer-navbar.css" rel="stylesheet">
	
	<!--
    <link href="http://getbootstrap.com/examples/navbar-fixed-top/navbar-fixed-top.css" rel="stylesheet">
	-->
	<style>
		body { 
			min-height: 500px;
			padding-top: 70px;
		}
	</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div>
			<ul class="nav navbar-nav">
				<li class="active"><a href='<spring:url value="/" />'>Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</div>
</nav>
<div class="container">
<tiles:insertAttribute name="body" />
</div>
<footer class="footer">
	<div class="container">
		<center>
			<p class="text-muted"><tiles:insertAttribute name="footer" /></p>
		</center>
	</div>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</body>
</html>