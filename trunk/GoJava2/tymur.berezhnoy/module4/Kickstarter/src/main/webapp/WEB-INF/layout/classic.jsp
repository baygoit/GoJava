<%@ include file="../layout/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>

	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title><tiles:getAsString name="title" /></title>
	
	<link href="<c:url value="/favicon.ico"/>" type="image/x-icon" rel="icon" />
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/sticky_footer.css" />" rel="stylesheet">
	<!--<link href="http://getbootstrap.com/examples/navbar-fixed-top/navbar-fixed-top.css" rel="stylesheet">-->
	 
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-validation.js" />"></script>
	<style>
		body { 
			min-height: 500px;
			padding-top: 70px;
		}
	</style>
</head>
<body>
<tilesx:useAttribute name="current"/>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div>
			<ul class="nav navbar-nav navbar-left">
				<li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/" />'><span class="glyphicon glyphicon-home"></span> Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="! isAuthenticated()">
					<li class="${current == 'register' ? 'active' : ''}"><a href='<spring:url value="/register.html" />'><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
					<li class="${current == 'login' ? 'active' : ''}"><a href='<spring:url value="/login.html" />'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">My account <span class="caret"></span></a>
               			<ul class="dropdown-menu" role="menu">
               				<li class="${current == 'account-manage' ? 'active' : ''}"><a href='<spring:url value="/account-manage.html" />'><span class="glyphicon glyphicon-cog"></span> Manage</a></li>
								<security:authorize access="hasRole('ROLE_ADMIN')">
									<li class="${current == 'users' ? 'active' : ''}"><a href='<spring:url value="/users.html" />'><span class="glyphicon glyphicon-user"></span> Users</a></li>
								</security:authorize>
               				<li class="divider"></li>
               				<li class="dropdown-header">Other</li>
               				<li><a href='<spring:url value="/logout" />'><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                		</ul>
					</li>
				</security:authorize>
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
</body>
</html>