<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Investment</title>
</head>
<body>
    <p>
        <a href="projectServlet?projectId=${projectId}"> Back </a>
    </p>
	<form action="paymentServlet" method="POST">
	<p><input type="radio" name="amount" value="0" checked/>Any amount </p>
		<c:forEach var="reward" items="${rewards}" varStatus="varStatus">
			<p><input type="radio" name="amount" value="${reward.amount}">${reward.name} - ${reward.description}</p>
		</c:forEach>
	<hr/>
    <p><b>Enter amount of investment</b></p>
        <input type="number" name="investment" max="2147483647" min="1" />
       <p><b> Your name</b></p>
			<input type='text' name='cardholder_name'/><br/>
			<p><b> Card number</b></p>
			<input type='text' name='card_number'/><br/>
         <input type="hidden"
            name="projectId" value="${projectId}" /> 
            <p><input type="submit"
            value="Submit" /></p>
    </form>
    
</body>
</html>