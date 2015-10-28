<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         import="model.Project"
         pageEncoding="ISO-8859-1" %>
<%@ page import="model.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Kickstarter</title>
    <style type="text/css">
        a{
            text-decoration: none;
        }
        /*div.Vertical_location{*/
            /*display: inline-table;*/
        /*}*/

        #horizontal_display {
            /*position: absolute;*/
            vertical-align: bottom;
            display: inline;
            direction: ltr;
            /*direction: ;*/
            /*background: #dcdcdc;*/
            /*padding: 5px;*/
            /*margin: 5px;*/
        }
    </style>
</head>
<body>
<%Category category = (Category) request.getAttribute("category");
  Project project = (Project) request.getAttribute("project");%>

<h1 style="text-decoration: #20b2aa"> Category/project: ${requestScope.get("category").name}/${requestScope.get("project").name}</h1>
<h2 style="text-shadow: #4169e1">Description of project</h2>

<div align="left">
    <table frame="box" style="list-style: inherit" width="100%" border="1">
        <tr>
            <td width="20%">Name</td>
            <td width="40%">Description</td>
            <td width="15%">Requirement</td>
            <td width="15%">Balance</td>
            <td width="10%">Days left</td>
        </tr>
        <tr>
            <td><%= project.getName()%>
            </td>
            <td><%= project.getFullDescription()%>
            </td>
            <td><%= project.getRequirementAmount()%>
            </td>
            <td><%= project.getBalancedAmount()%>
            </td>
            <td><%= project.getDaysLeft()%>
            </td>
        </tr>
    </table>
</div>
    <form action="term" method="POST">
        <%--<hr size="0">--%>
        <p><b>Choose version:</b></p>
        <%
            for (Project.Terms elemOfTerms : project.getTermsList()) {
        %>
            <%--<p><input name="choice" type="radio" onclick="radioAction(this, null)" value=<%=elemOfTerms.getId()%>>--%>
            <p><input name="choice" type="radio" value=<%=elemOfTerms.getId()%>>
                Invest <%=elemOfTerms.getPayAmount() + "$ - " + elemOfTerms.getDefinitionOfAdvantage()%></p>
        <%
            }
        %>
        <span id="horizontal_display">
            <%--<p><input name="choice" type="radio" onclick="radioAction(this, userValue)" value="userAmount">--%>
            <p><input name="choice" type="radio" value="userAmount">
                my choice:
            <input type="number" name="userValue" id="userValue"> </p>
        </span>
        <%--</hr>--%>
    <%--</form>--%>
    <%--<form action="payment" method="POST">--%>
        <div>
            <p>Please enter your Name:  <input type="text" name="nameUser" size="20px"> <br> </p>
            <p>Please enter your Card:  <input type="text" name="card" size="20px"> <br> </p>

            <input type="hidden" name="categoryId" value=<%= category.getId()%>>
            <input type="hidden" name="projectId" value=<%= project.getId()%>>
            <button type="submit" value="InvestAgree" name="chooseOfInvest" style="appearance: normal" id="InvestAgree">Agree</button>
            <button type="submit" value="InvestDisagree" name="chooseOfInvest" style="appearance: normal" id="InvestDisagree">Disagree</button>
        </div>
    </form>

</body>
</html>