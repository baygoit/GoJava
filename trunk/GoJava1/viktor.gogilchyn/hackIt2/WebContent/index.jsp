<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map"%>
<%@ page import="ua.com.goit.gojava1.lslayer.hackit2.actor.Actor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%Map<Actor> list = (Map<Actor>)session.getAttribute("gamers"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Actor list</title>
</head>
<body>
<table>
    <%
    for(int i=0; i<list.size();i++){%>
        <tr>
            <td><%= ((Actor)list.get(i)).getName() %></td>
        </tr>
      <%}%>
</table>
</body>
</html>