<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<body>
<h1>This is jsp</h1>
<%
    String username = request.getParameter("username");
    if (StringUtils.isNotBlank(username)) {
%>
    <h2>Hello <%=username%></h2>
<%
    }  else {%>
    <h2>Hello, whoever you are!</h2>
<%
    }
%>
</body>
</html>
