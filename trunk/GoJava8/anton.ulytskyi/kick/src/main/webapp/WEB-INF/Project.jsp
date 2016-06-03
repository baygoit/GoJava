<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    
<title>Kickstarter</title>

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
	
<input type="hidden" name="projectId" value="${projectId}" />
	
invest: <input name="invest"  placeholder="0" value="">
	
<input type="submit" name="Invest" value="Invest">
	
<div style="font-size:32px;">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</div>

author: <input name="author" placeholder="author" value="">
<br>
	
question: <input name="text" placeholder="text" value="">
<br>
	
<input type="submit" name="Ask" value="Ask">	
	
<div style="font-size:32px;">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</div>

</form>

<a href="/kickstarterWEB/categories">previous</a>


</center>
</body>

</html>