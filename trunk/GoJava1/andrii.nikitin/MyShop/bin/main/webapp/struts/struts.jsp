<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Struts 2 Application - Welcome</title>
	</head>
	<body>
	
	<s:url action="struts2.action" var="struts2"/>
	<s:url action="good_getall.action" var="getallgoods"/>


		<h1>Welcome To Struts 2!</h1>
		<p>
			<a href="<s:property value="#getallgoods"/>"> get all goods	</a>
		</p>
		<p>
			<a href="<s:url value="#struts2"/>"> refresh </a>
		</p>
	</body>
</html>
