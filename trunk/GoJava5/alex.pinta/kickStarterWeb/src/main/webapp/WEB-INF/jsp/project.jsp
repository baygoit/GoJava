<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         import="model.Project"
         import="model.Category"
         pageEncoding="ISO-8859-1" %>
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
        /*a:visited{*/
            /**/
        /*}*/
        /*a:link{*/
            /**/
        /*}*/

        /*a:hover {*/
            /*letter-spacing: 10px;*/
            /*font-weight:bold;*/
            /*color:red;*/
        /*}*/


        /*a {*/
            /*color: blue;*/
        /*}*/

        /*a.whitewine {*/
            /*color: #FFBB00;*/
        /*}*/

        /*a.redwine {*/
            /*color: #800000;*/
        /*}        */

        /******************************************/
    /*<h1 id="c1">????? 1</h1>*/
	/*<h2 id="c1-1">????? 1.1</h2>*/
	/*<h2 id="c1-2">????? 1.2</h2>*/
	/*<h1 id="c2">????? 2</h1>*/
	/*<h2 id="c2-1">????? 2.1</h2>*/
	/*<h3 id="c2-1-2">????? 2.1.2</h3>*/

        /*#c1-2 {*/
            /*color: red;*/
        /*}*/
       /******************************************/
        #horizontal_display {
            vertical-align: bottom;
            display: inline;
            direction: ltr;
        }
    </style>
</head>
<body>

<%Category category = (Category) request.getAttribute("category");
  Project project = (Project) request.getAttribute("project");%>

<h1 style="text-decoration: #20b2aa"> Category/project: ${requestScope.get("category").name}/${requestScope.get("project").name}</h1>


    <h2 style="text-shadow: #4169e1">Description of project</h2>
    <form action="/investation" style="vertical-align: baseline">
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

        <input type="hidden" name="categoryId" value=<%= category.getId()%>>
        <input type="hidden" name="projectId" value=<%= project.getId()%>>
        <input type="submit" name="approve" value="Invest to project">
    </div>
    </form>

<%--<div align="left">--%>
    <h2 style="text-shadow: aqua">History</h2>

    <form action="/history">
        <table frame="box" style="list-style: inherit" width="100%" border="1">
            <tr>
                <td width="70%">Description</td>
                <td width="15%">User</td>
                <td width="15%">Date</td>
            </tr>
            <%
                for (Project.History elemOfHistory : project.getHistoryOfProject()) {
            %>
            <tr>
                <td><%=elemOfHistory.getDescription()%>
                </td>
                <td><%=elemOfHistory.getUserName()%>
                </td>
                <td><%=elemOfHistory.getDateAdded()%>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </form>

    <h2 style="text-shadow: aqua">Video links</h2>
    <form action="/links">
        <%
            for (Project.VideoLink elemOfVideoLink : project.getDemoLink()) {
        %>
        <ol>
            <%--<%=elemOfVideoLink.link%>--%>
            <li><a href=<%=elemOfVideoLink.getLink()%>--%>><%=elemOfVideoLink.getDescription()%>
            </a>
            </li>
        </ol>
        <%
            }
        %>
    </form>

<%Boolean modePrepareQuestion = (Boolean) request.getAttribute("modePrepareQuestion");%>
<h2 style="text-shadow: aqua">Question answer</h2>
<form action="/question" method="POST">

    <input type="hidden" name="categoryId" value=<%= category.getId()%>>
    <input type="hidden" name="projectId" value=<%= project.getId()%>>

    <table frame="box" style="list-style: inherit" width="100%" border="1">
        <tr>
            <td width="70%">Description</td>
            <td width="15%">User</td>
            <td width="15%">Date</td>
        </tr>
        <%
            for (Project.QuestionAnswer elemOfQuestionAnswer : project.getUserQuestion()) {
        %>
        <tr>
            <td><%=elemOfQuestionAnswer.getDescription()%>
            </td>
            <td><%=elemOfQuestionAnswer.getUserName()%>
            </td>
            <td><%=elemOfQuestionAnswer.getDateAdded()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <p></p>
    <%
    if (modePrepareQuestion == Boolean.TRUE){
    %>
        <form action="/preparedQuestion" method="POST">
        <span style="display: table-row">
            Your question: <input type="text" name="userQuestion_description" size="80%">
            Your name: <input type="text" name="userQuestion_userName" size="80%">
        </span>

        <span id="horizontal_display">
            <p><input type="submit" name="userQuestion_SubmitCancel" value="Submit">
                <input type="submit" name="userQuestion_Cancel" value="Cancel">
            </p>
        </span>

        </form>
    <%
    } else {
    %>
        <input type="submit" name="askQuestion" value="Ask a question">
    <%
    }
    %>

</form>
</body>
</html>