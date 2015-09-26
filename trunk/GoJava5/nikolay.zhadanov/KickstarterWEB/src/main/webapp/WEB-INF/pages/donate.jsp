<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Donate</title>
</head>
<body>
	<c:choose>
		<c:when test="${confirmed}">
			<h2>Thank you for your donate!</h2>
			<br>
			<br>
			<br>
		</c:when>
		<c:otherwise>
			<h2>Payment Page</h2>
			<br>
			<c:choose>
				<c:when test="${chosenAmount > 0}">
					<b>Payment amount = <c:out value="${chosenAmount}" /></b>
				</c:when>
			</c:choose>
			<form action="thankyou" method="POST">
				Enter your Name: <input type="text" name="name" size="20px">
				<br> Enter your Card Number: <input type="text" name="card"
					size="20px"> <br>
				<c:choose>
					<c:when test="${chosenAmount > 0}">
						<input type="hidden" name="chosenAmount" value="${chosenAmount}" />
					</c:when>
					<c:otherwise>
    	Enter Pledge Sum:        <input type="number" name="chosenAmount"
							size="20px">
						<br>
					</c:otherwise>
				</c:choose>
				<br> <input type="submit" value="Make Donate">
			</form>
			<br>
			<br>
			<br>
		</c:otherwise>
	</c:choose>
	<b><a
		href="/KickstarterWEB/main/category/${project.category.id}/project/${project.id}/view">Back</a></b>
</body>
</html>
