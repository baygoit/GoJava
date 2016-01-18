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
    Project project = (Project) request.getAttribute("project");
    Category category = (Category) request.getAttribute("category");
    int categoryId = (Integer) request.getAttribute("categoryId");
    String sum = request.getParameter("sum");
%>
<h3>Category: <a href="category?id=<%= categoryId %>"><%= category.getName() %></a><br />
Project: <%= project.getName() %><br /></h3>
<br />
<b>Description:</b> <%= project.getDescription() %><br />
<b>History:</b> <%= project.getHistory() %><br />
<b>Video:</b> <a href="<%= project.getVideoUrl() %>"><%= project.getVideoUrl() %></a><br />
<b>Money needed:</b> $<%= project.getMoneyNeeded() %><br />
<b>Money donated:</b> $<%= project.getMoneyDonated() %><br />
<b>Days left:</b> <%= project.getDaysLeft() %><br />
<%
    List<String> questions = project.getQuestions();
    if (questions.size() > 0) {
%>
<br />
<b>Questions:</b><br />
<font size="-1">
<%
        for (String question : questions) {
            out.println(question + "<br /><br />");
        }
    }
%>
</font>
<br />
<%
    session.setAttribute("project", project); // TODO
    session.setAttribute("category", category);
    session.setAttribute("categoryId", categoryId);
%>
Would you like to ask a question?<br />
<form action="question" method="post">
    <textarea name="question" placeholder="your question..."></textarea>
    <br />
    <input type="submit" value="Ask"/>
</form>
<br />
Would you like to donate?<br />
<%
    if (sum != null && sum.equals("other")) {
%>
<form action="donate" method="post">
    <select>
        <option selected>other</option>
    </select>
    <input type="text" name="sum" placeholder="Enter your sum..." />
    <input type="submit" value="Donate"/>
</form>
<%
    } else {
%>
<form action="donate" method="post">
    <select name="sum">
        <option value="1">$1</option>
        <option value="10" selected>$10</option>
        <option value="40">$40</option>
        <option value="other">other</option>
    </select>
    <input type="submit" value="Donate"/>
</form>
<%
    }
%>


<p align="center">
    <a href="start">Main page</a>
</p>
</body>
</html>
