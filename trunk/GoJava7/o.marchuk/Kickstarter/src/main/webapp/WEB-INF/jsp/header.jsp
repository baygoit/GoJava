<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>
	<c:if test="${not empty param.title}">${param.title}</c:if>
	<c:if test="${empty param.title}">Default title</c:if>
</title>
</head>
<body>