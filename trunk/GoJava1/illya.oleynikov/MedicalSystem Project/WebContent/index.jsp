<%@page import="ua.com.goit.gojava.alejnikovi.medsystem.Specialization"%>
<%@page import="java.util.Set"%>
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
        <%Set <Specialization> set = Specialization.getSpecializations();
          for (Specialization spec: set) {%>
           <%="<tr><td>" + spec.getName() + "</td></tr>"%>
        <%} %>
    </table>
    <p>
    <form action="CreateNew" method="GET">
        <input name="specialization" type="text">
        <input type="submit" value="Submit">
    </form>
    </p>
    <p>
    <a href="UpdateList.jsp">Изменить список</a>
    </p>
</body>
</html>