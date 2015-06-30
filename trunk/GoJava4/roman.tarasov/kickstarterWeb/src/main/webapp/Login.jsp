<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="project page"
		onclick="self.location='DetailedProject?project=${project}&category=${category}';" />
	<h1>LOGIN</h1>
	<c:if test="${user!=null}">
		<p>
			<c:out value="user :  ${userName}" />
		<p>
	</c:if>
		<c:if test="${user==null}">
		<p>
			<c:out value="Not logged" />
		<p>
	</c:if>
	<form action="login?project=${project}&category=${category}" method="post">
		Username(user): <input type="text" name="login"> <br>
		Password(pass): <input type="password" name="pwd"> <br> <input
			type="submit" value="Login">
	</form>
</body>
</html>