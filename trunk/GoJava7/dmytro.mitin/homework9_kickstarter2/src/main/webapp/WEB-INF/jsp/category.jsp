<%@ page import="ua.com.goit.gojava7.kickstarter.domain.Category" %>
<%@ page import="ua.com.goit.gojava7.kickstarter.domain.Project" %>
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
<h3>Category: <a href="category?id=<%= request.getParameter("id") %>"><%= category.getName() %></a></h3>
<ul>
<%
    for (int i = 0; i < projects.size(); i++) {
        Project project = projects.get(i);
%>
<li>
<b>Project:</b>
<a href="project?id=<%= i %>&categoryId=<%= request.getParameter("id") %>"><%= project.getName() %></a><br />
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
<a href="/">Main page</a>
</p>
</body>
</html>
