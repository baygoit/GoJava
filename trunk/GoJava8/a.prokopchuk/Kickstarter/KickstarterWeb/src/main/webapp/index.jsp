<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link rel="icon" type="image/png" href="<c:url value="/kickstarter/resources/images/favicon.ico" />"/>
  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="<c:url value="/resources/css/style.css" />" type="text/css" rel="stylesheet">
	<title>KickStarter</title>
</head>
<body id="index">
	<div class="header-index">
		<div class="logo-index" >
			<a href="categories">
				<img src="<c:url value="/resources/images/logo2.png" />">
			</a>
		</div>
		<h1 class="title"><a href="<c:url value="categories" />">Welcome to KickStarter...</a></h1>
	</div>
</body>
</html>