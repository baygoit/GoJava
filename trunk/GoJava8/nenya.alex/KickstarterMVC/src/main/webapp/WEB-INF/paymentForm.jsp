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
        <a href="<c:url value="/project/${project.id}"/>" > Back </a>
    </p>
	<form:form action="addPayment" method="post" modelAttribute="paymentForm">
                <p><b>Enter amount of investment</b></p>
                <form:input type="number" path="amount" placeholder="0"/>
                 <form:errors path="amount"/> 
                <p><b> Your name</b></p>
			     <form:input type="text" path="cardholderName"/><br/>
			      <form:errors path="cardholderName"/> 
			     <p><b> Card number</b></p>
			     <form:input type='text' path='cardNumber'/><br/>
			     <form:errors path="cardNumber"/> 
                <form:input type="hidden" path="project.id" value="${project.id}" /> 
          <p><input type="submit" value="Submit" /></p>
    </form:form>
    
    <p> <h2>Get your own REWARD!!!</h2> </p>
    
        <c:forEach var="reward" items="${rewards}">
         <p> <a href="<c:url value="/reward/${reward.id}"/>" >${reward.name}</a> - ${reward.description}</p>
        </c:forEach>
          
</body>
</html>