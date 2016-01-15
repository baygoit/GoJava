<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<h3>Pledge:</h3>

<c:if test="${errors}">
	<p style="color:red">errors</p>
</c:if>
	
<form action="pledge.html?rewardId=${rewardId}&projectId=${projectId}&amount=${amount}"
	method="post">
	<p>
		<input type="text" name="name" placeholder="name" required>
	</p>
	<p>
		<input type="text" name="cardNumber" placeholder="card number" required>
	</p>
	
	<p>
		<input type="number" name="amount" required value="${amount}" <c:if test="${rewardId != 0}"> disabled</c:if>>
	</p>
	
	<p>
		<input type="submit" value="Donate">
	</p>
</form>

<jsp:include page="footer.jsp" />