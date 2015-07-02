<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project menu</title>
</head>
<body>
		<h1>
			Project info:
		</h1>
		<h2>
			
				<c:out value="${project.name}" /><br>
				DaysLeft:
				<c:out value="${project.daysLeft}" /><br>
				MoneyGot:
				<c:out value="${project.moneyGot }" /> <br>
				MoneyNeed:
				<c:out value="${project.moneyNeed }" /> <br>
				
			
			
		</h2>
	

</body>
</html>