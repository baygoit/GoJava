<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World - JSP</title>
</head>
	<body>
	<form action="HelloWorldServlet" method="post">
		Print your sentence and chose language to speech (by default sentence is "Hello World")! 
		<p><textarea name="sent" rows="10" cols="25">Hello World</textarea></p>
		<input type="submit" name="lang" value="en">
		<input type="submit" name="lang" value="ru">
		<input type="submit" name="lang" value="de">
		<input type="submit" name="lang" value="fr">
	</form>
	</body>
</html>