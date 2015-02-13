<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error</title>
</head>
<body>
<%
String errorDiscription = request.getParameter("errorDiscription"); 
if (errorDiscription==null || errorDiscription.length()==0) {
%>	
error
<% 
} else { %>
<b>
error: <%=errorDiscription%>
</b>
<%
}
%>
</body>
</html>