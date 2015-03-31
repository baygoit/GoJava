<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thanks for you donation</title>
</head>
<body>
	<p>message : ${success}</p>
	<p>Go back to <a href="${ctx}/projects/${project}?show">project # ${project}</a></p>
</body>
</html>