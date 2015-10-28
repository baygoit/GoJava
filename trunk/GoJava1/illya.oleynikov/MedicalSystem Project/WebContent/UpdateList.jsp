<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="ua.com.goit.gojava.alejnikovi.medsystem.Specialization"%>
<%@page import="java.util.Set"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
<b>Список всех специализаций:</b><br>
    <select>
        <%Set <Specialization> set = Specialization.getSpecializations();
          for (Specialization spec: set) {%>
           <%="<option value='" + spec.getName() + "'>" + spec.getName() + "</option>"%>
        <%} %>
    </select>
    <p>
    <b>Задайте новое значение:</b><br>
    <form action="CreateNew" method="GET">
        <input name="specialization" type="text">
        <input type="submit" value="Submit">
    </form>
    </p>
</body>
</html>