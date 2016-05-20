<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Reward</title>
</head>
<body>
    <p>
        <a href="<c:url value="/project/${project.id}"/>" > Back </a>
    </p>
    <form:form action="addReward" method="post" modelAttribute="rewardForm">
                <form:input type="hidden" path="amount" value="${reward.amount}" /> 
                <p><b> Your name</b></p>
                 <form:input type="text" path="cardholderName"/><br/>
                  <form:errors path="cardholderName"/> 
                 <p><b> Card number</b></p>
                 <form:input type='text' path='cardNumber'/><br/>
                 <form:errors path="cardNumber"/> 
                <form:input type="hidden" path="project.id" value="${project.id}" /> 
          <p><input type="submit" value="Submit" /></p>
    </form:form>
</body>
</html>