<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Pledge</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.done == 'yes'}">
			<h2>Thank you for your donate!</h2>
			<br>
			<br>
			<br>
		</c:when>
		<c:otherwise>
			<h2>Payment Page</h2>
			<br>
			<c:choose>
				<c:when test="${param.amount > 0}">
					<b>Payment amount = <c:out value="${param.amount}" /></b>
				</c:when>
			</c:choose>
			<form action="pledge" method="POST">
				Enter your Name: <input type="text" name="name" size="20px">
				<br> Enter your Card Number: <input type="text" name="card"
					size="20px"> <br>
				<c:choose>
					<c:when test="${param.amount > 0}">
						<input type="hidden" name="pledgeAmount" value="${param.amount}" />
					</c:when>
					<c:otherwise>
    	Enter Pledge Sum:        <input type="number" name="pledgeAmount"
							size="20px">
						<br>
					</c:otherwise>
				</c:choose>
				<br> <input type="hidden" name="id" value="${param.id}" /> <input
					type="submit" value="Make Donate">
			</form>
			<br>
			<br>
			<br>
		</c:otherwise>
	</c:choose>
	<b><a href="project?id=${param.id}&action=view">Back</a></b>
</body>
</html>
