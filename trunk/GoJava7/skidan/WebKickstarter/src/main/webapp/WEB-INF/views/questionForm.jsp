<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Question Input Form</title>
</head>
<body id="b">


<div align="center">
    <h2>Please input your question in form below</h2>
    <table border="0" width="90%">
        <form:form action="/WebKickstarter/question/add" method="post" commandName="questionVo">
            <tr>
                <td align="left"> Question:</td>
                <td align="left" width="40%"><form:input path="question" size="30"/></td>
                <td align="left"><form:errors path="question" cssClass="error"/></td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><input type="hidden" name="projectId" value="${projectId}"/></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td align="left"><input id="subm" type="submit" value="Ask your question"/></td>
                <td></td>
            </tr>
        </form:form>
    </table>

</div>
</body>
</html>

<!-- <input type="hidden" name="projectId" value="${projectId}" />
<input name="question" />
<input id="subm" type="submit" value="add question" /> -->