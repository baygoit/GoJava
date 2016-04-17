<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kickstart</title>
</head>
<body>
<center>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
<h1>${project[0]}</h1>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
  
<c:forEach items="${project}" var="information" begin="1">
${information}
<br>
</c:forEach>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
<form method="post">
invest: <input name="invest" value="0">
<input type="submit" name="Invest" value="Invest">
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
author: <input name="author" value="author"><br>
question: <input name="text" value="text"><br>
<input type="submit" name="Ask" value="Ask">	
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
</form>
<a href=/kickstart-0.0.1-SNAPSHOT/categories>previous</a>
</center>
</body>
</html>