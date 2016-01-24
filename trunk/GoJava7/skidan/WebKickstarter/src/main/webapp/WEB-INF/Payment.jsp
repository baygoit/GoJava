<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body id ="b">

<div align="center">
        <h2>Please fill in forms below</h2>
        <table border="0" width="90%">
        <form:form action="/WebKickstarter/payment/proceed" method = "post" commandName="payerVo">
        <tr>
                <td align="left" > Payment Amount: </td>
                    <td align="left" width="40%"><form:input path="paymentAmount" size="30" value="${paymentAmount}"/></td>
                    <td align="left"><form:errors path="paymentAmount" cssClass="error"/></td>
                </tr>
                <tr>
                <td align="left" > Card Holder Name: </td>
                    <td align="left" width="40%"><form:input path="cardHolderName" size="30"/></td>
                    <td align="left"><form:errors path="cardHolderName" cssClass="error"/></td>
                </tr>
                <tr>
                <td align="left" > Card Number: </td>
                    <td align="left" width="40%"><form:input path="cardNumber" size="30"/></td>
                    <td align="left"><form:errors path="cardNumber" cssClass="error"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="center"><input type ="hidden" name="projectId" value="${projectId}" /></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left"><input id = "subm" type="submit" value="approve payment"/></td>
                    <td></td>
                </tr>
        </form:form>
        </table>
         
    </div>







</body>
</html>


<!-- <form method ="post" action ="proceed">
<input type ="hidden" name = "projectId" value = "${projectId}" />
<input type ="hidden" name ="paymentAmount" value ="${paymentAmount}"/>
<input name ="payerName" value ="Card Holder Name"/><br><br>
<input name ="cardNumber" value = "Card Number"/><br><br>
<input type = "submit" value = "approve payment"/></form><br> -->