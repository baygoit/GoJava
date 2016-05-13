<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />" />
<script src="<c:url value="/js/jquery-2.2.3.min.js" />"></script>
<c:if test="${null != script}">
<script src="${script}"></script>
</c:if>
<title>Kickstarter: ${title}</title>
</head>
<body>
	<div class="div_main_header">Kickstarter</div>
	<div class="div_main_wrapper">