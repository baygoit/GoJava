<%@page import="ua.com.goit.gojava.alejnikovi.medsystem.Specialization"%>
<%@page import="ua.com.goit.gojava.alejnikovi.medsystem.MedicalSystem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%List<Specialization> list = MedicalSystem.getSpecializations();%>

<%for (Specialization spec: list) {%>
    <%=spec.getName() + ", "%>
<%} %>

</body>
</html>