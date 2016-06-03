<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link rel="icon" type="image/png" href="<c:url value="/resources/images/favicon.ico" />"/>
  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>
		<c:if test="${not empty param.title}">${param.title}</c:if>
		<c:if test="${empty param.title}">Kickstarter</c:if>
	</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/common.js" />"></script>
</head>

<body>
	<div class="content">
		<div class="language-panel">
			<div class="container">
				<div class="row">
					<span>
						<a href="?lang=en"><img src="<c:url value="/resources/images/en.png" />" alt="en"></a>
						<a href="?lang=ua"><img src="<c:url value="/resources/images/ua.png" />" alt="ua"></a>
					</span>
				</div>
			</div>
		</div>
		<div class="header">
			<div class="logo" >
				<a href="/kickstarter">
					<img src="<c:url value="/resources/images/logo.jpg" />" alt="logo">
				</a>
			</div>
		</div>