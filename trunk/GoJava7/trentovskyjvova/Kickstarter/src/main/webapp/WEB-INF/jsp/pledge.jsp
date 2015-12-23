<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<h3>Pledge:</h3>

<c:if test="${errors}">
	<p style="color:red">errors</p>
</c:if>
	
<form action="pledge?rewardId=${rewardId}&projectId=${projectId}"
	method="post">
	<p>
		<input type="text" name="name" placeholder="name" required>
	</p>
	<p>
		<input type="text" name="cardNumber" placeholder="card number" required>
	</p>
	<c:if test="${rewardId == 0}">
		<p>
			<input type="number" name="amount" placeholder="amount" required>
		</p>
	</c:if>
	<p>
		<input type="submit" value="Donate">
	</p>
</form>

<jsp:include page="footer.jsp" />