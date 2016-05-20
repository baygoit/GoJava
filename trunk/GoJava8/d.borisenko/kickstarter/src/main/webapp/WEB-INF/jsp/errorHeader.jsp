<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<head>
<title>${title}</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/main.css" />" />
<script src="<c:url value="/js/jquery-2.2.3.min.js" />"></script>
<c:if test="${null != script}">
	<script src="${script}"></script>
</c:if>
<title>Kickstarter: ${title}</title>
</head>
<body>
	<div class="div_main_header">Kickstarter</div>
	<div class="div_main_wrapper">
