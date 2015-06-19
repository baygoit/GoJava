<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="project page"
		onclick="self.location='/edu.kickstarter/DetailedProject';" />
	<h1>LOGIN: (Username: user , Password: pass)   </h1>
	<form action="login" method="post">
		Username: <input type="text" name="login"> <br>
        Password: <input type="password" name="pwd"> <br> <input
			type="submit" value="Login">
	</form>
</body>
</html>