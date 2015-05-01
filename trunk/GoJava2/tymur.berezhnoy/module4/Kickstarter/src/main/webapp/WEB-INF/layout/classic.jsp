<%@ include file="../layout/taglib.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
	
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title><tiles:getAsString name="title" /></title>
	
	<link href="<c:url value="/favicon.ico"/>" type="image/x-icon" rel="icon" />
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/sticky_footer.css" />" rel="stylesheet">
	<!--<link href="http://getbootstrap.com/examples/navbar-fixed-top/navbar-fixed-top.css" rel="stylesheet">-->
	 
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
			<ul class="nav navbar-nav navbar-left">
				<li><a href='<spring:url value="/" />'><span class="glyphicon glyphicon-home"></span> Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="${current == 'register' ? 'active' : ''}"><a href='<spring:url value="/register.html" />'><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
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
		<p align="center" class="text-muted"><tiles:insertAttribute name="footer" /></p>
	</div>
</footer>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>