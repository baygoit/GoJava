<%@page import="ua.com.goit.gojava.alejnikovi.medsystem.*"%>
<%@page import="ua.com.goit.gojava.alejnikovi.medsystem.dao.SpecializationsDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
    <b>Список всех специализаций:</b><br>
    <table border="1">
        <%
         	SpecializationsDAO db = new SpecializationsDAO();
                 List <Specialization> specs = db.getAll();
                   for (Specialization spec: specs) {
         %>
           <%="<tr><td>" + spec.getName() + "</td>"+
                   "<td><input type='submit' value='Delete'></td></tr>"%>
        <%} %>
    </table>
    <p>
    <form action="CreateNew" method="POST">
        <input name="createSpecialization" type="text">
        <input type="submit" value="Submit">
    </form>
        <form action="CreateNew" method="POST">
        <input name="deleteSpecialization" type="text">
        <input type="submit" value="Delete">
    </form>
    </p>
    <p>
    <a href="UpdateList.jsp">Изменить список</a>
    </p>
    
</body>
</html>