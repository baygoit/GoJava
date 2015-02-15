<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ua.com.goit.gojava1.lslayer.hackit2.actor.Actor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%List<Actor> gamersList =(List<Actor>)request.getAttribute("gamers"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Actor list</title>
</head>
<body>
<div class="container">
<%Iterator<Actor> iter = gamersList.iterator();
while(iter.hasNext()) { %>
    <div class="one_gamer_container">
    <%Actor element = iter.next();%>
    <div class="gamer_name_container">
    <h1><%out.print("Name: " + element.getName()); %></h1>
    <div class="gamer_skills_container">
        <%for (Map.Entry<String, Integer> entry : element.getSkills().entrySet()) {%>
            <div class="one_skill_container">
            <span class="gamer_skills_name">
            <%out.print(entry.getKey());%>
            </span>
            <span class="gamer_skills_value">
            <%out.print(entry.getValue());%>
            </span>
            </div>
        <%}%>
    </div>
    </div>
    </div>
<%}%>
</div>
<a href="addform.jsp">Create</a>
<a href="#">Read</a>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>