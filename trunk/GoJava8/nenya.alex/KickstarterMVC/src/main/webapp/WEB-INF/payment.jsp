<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Investment</title>
</head>
<body>
    <p>
        <a href="<c:url value="/category/project/${project.id}"/>" > Back </a>
    </p>
	<form:form action="${project.id}/add" method="post" modelAttribute="paymentForm">
	   <p><form:radiobutton path="amount" value="0" checked="checked" />Any amount </p>
		<c:forEach var="reward" items="${rewards}" varStatus="varStatus">
			<p><form:radiobutton path="amount" value="${reward.amount}"/>${reward.name} - ${reward.description}</p>
		</c:forEach>
	       <hr/>
                <p><b>Enter amount of investment</b></p>
                <form:input type="number" path="investment" max="2147483647" min="0" />
                <p><b> Your name</b></p>
			     <form:input type='text' path='cardholderName'/><br/>
			     <p><b> Card number</b></p>
			     <form:input type='text' path='cardNumber'/><br/>
                <form:input type="hidden" path="project.id" value="${project.id}" /> 
          <p><input type="submit" value="Submit" /></p>
    </form:form>
    
</body>
</html>