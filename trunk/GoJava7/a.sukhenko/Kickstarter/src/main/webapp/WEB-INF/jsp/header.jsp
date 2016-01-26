<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
/* Effect 15: scale down, reveal */
.cl-effect-15 a {
	color: rgba(0,0,0,0.2);
	font-weight: 700;
	text-shadow: none;
}

.cl-effect-15 a::before {
	color: #fff;
	content: attr(data-hover);
	position: absolute;
	transition: transform 0.3s, opacity 0.3s;
}
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

.cl-effect-15 a:hover::before,
.cl-effect-15 a:focus::before {
	transform: scale(0.9);
	opacity: 0;
}
</style>
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<title>
	<c:if test="${not empty param.title}">${param.title}</c:if>
	<c:if test="${empty param.title}">Default title</c:if>
</title>
</head>
<body>
<p align=center><h1>Kickstarter (Artur.Sukhenko) </h1> </p>
