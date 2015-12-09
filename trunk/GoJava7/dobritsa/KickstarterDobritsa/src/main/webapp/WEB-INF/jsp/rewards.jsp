<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Rewards" />
</jsp:include>

<h1>${projectName}</h1>
<h3>Let's choose your reward!</h3>


<a href="payment?id=0">No thanks, I just want to help the project.</a>

<ul>
		<c:forEach var="reward" items="${requestScope.rewards}">
		<li>
			<p>
		<a href="payment?id=${reward.id}">${reward.amount}</a>
		
		<br>${reward.reward}
		</p>
		</li>
		</c:forEach>
	</ul>



<jsp:include page="footer.jsp" />