<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<h3>Pledge:</h3>

<form action="pledge?rewardId=${rewardId}&projectId=${projectId}"
	method="post">
	<p>
		<input type="text" name="name" placeholder="name">
	</p>
	<p>
		<input type="text" name="cardNumber" placeholder="card number">
	</p>
	<c:if test="${rewardId == 0}">
		<p>
			<input type="text" name="amount" placeholder="amount">
		</p>
	</c:if>
	<p>
		<input type="submit" value="Donate">
	</p>
</form>

<jsp:include page="footer.jsp" />