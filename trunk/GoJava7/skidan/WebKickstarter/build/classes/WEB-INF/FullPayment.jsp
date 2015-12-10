<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FullPaymentJsp</title>
</head>
<body>

<form method ="post" action ="ProvidePaymentServlet">
<input type ="hidden" name = "projectId" value = "${projectId}" />
<input  name ="paymentAmount"  value ="Input payment amount"/><br><br>
<input name ="payerName" value ="Card Holder Name"/><br><br>
<input name ="cardNumber" value = "Card Number"/><br><br>
<input type = "submit" value = "approve payment"/></form><br>



</body>
</html>