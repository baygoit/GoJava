<%@ page import="ua.com.goit.gojava7.kickstarter.model.Category" %>
<%@ page import="ua.com.goit.gojava7.kickstarter.model.Project" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kickstarter</title>
</head>
<body>
<%
    Category category = (Category) request.getAttribute("category");
    List<Project> projects = category.getProjects();
%>
<h3>Category: <%= category.getName()%></h3>
<ul>
<%
    for (int i = 0; i < projects.size(); i++) {
        Project project = projects.get(i);
%>
<li>
<b>Project:</b>
<a href="project?id=<%= i %>&categoryId=<%= request.getAttribute("categoryId") %>"><%= project.getName() %></a><br />
<font size="-1">
<b>Description:</b> <%= project.getShortDescription() %><br />
<b>Money needed:</b> $<%= project.getMoneyNeeded() %><br />
<b>Money donated:</b> $<%= project.getMoneyDonated() %><br />
<b>Days left:</b> <%= project.getDaysLeft() %><br />
</font>
</li>
<%
    }
%>
</ul>
<p align="center">
<a href="start">Main page</a>
</p>
</body>
</html>
