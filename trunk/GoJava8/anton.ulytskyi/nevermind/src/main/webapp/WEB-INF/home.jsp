<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Philosophy</title>
</head>
<body>
  <h1>Philosophy</h1>
  <c:forEach var="p" items="${quote}">
    ${p.quote}<br/>
  </c:forEach>
   
  <h1>Add New</h1>
  <form method="post" action="addQuote">
  Quote: <input type="text" name="quote"/>
  <button>Add</button>
  </form>
</body>
</html>