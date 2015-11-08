<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Comment</h2>
	<input type="button" value="project page"
		onclick="self.location='DetailedProject?project=${project}&category=${category}';" />

	<c:if test="${userName==null}">
		<p>
			<c:out value=" only for registered user" />
		<p>
	</c:if>
	<c:if test="${userName!=null}">
		<form action="Comment?project=${project}&category=${category}" method="post">
			 <input type="text" name="commentForm"> <br>
			 <br> <input
				type="submit" value="Comment">
		</form>
	</c:if>
</body>
</html>