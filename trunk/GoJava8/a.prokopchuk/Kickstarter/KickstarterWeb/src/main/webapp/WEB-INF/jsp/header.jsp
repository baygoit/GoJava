<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link rel="icon" type="image/png" href="/resources/images/favicon.ico"/>
  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>
		<c:if test="${not empty param.title}">${param.title}</c:if>
		<c:if test="${empty param.title}">Kickstarter</c:if>
	</title>
	
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="content">
		<div class="header">
			<div class="logo" >
				<a href="categories">
					<img src="<c:url value="/resources/images/logo.jpg" />">
				</a>
			</div>
		</div>