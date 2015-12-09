<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Rewards" />
</jsp:include>

<h3><a href="categories">Kickstarter</a>
/
<a href="projects?id=${category.id}">${category.name}</a></h3>

<h1><a href="project?id=${project.id}">${project.name}</a></h1>

<c:if test="${empty rewards}">
	<h3>There are no rewards</h3>
	<form action="payment" method="get">
		<h3>No thanks, I just want to help the project.</h3>
		<label>I want to help the project.</label>		
		<input type="text" name="amount" value="1">
		<input type="hidden" name="projectId" value="${project.id}" />
		<input type="hidden" name="id" value="0" />
		<input type="submit" value="Continue" />
	</form>
</c:if>

<c:if test="${not empty rewards}">
	<h3>Let's choose your reward!</h3>
	
	<form action="payment" method="get">
		<h3>No thanks, I just want to help the project.</h3>
		<label>Pledge amount</label>		
		<input type="text" name="amount" value="1">
		<input type="hidden" name="projectId" value="${project.id}" />
		<input type="hidden" name="id" value="0" />
		<input type="submit" value="Continue" />
	</form>

	<ul>
		<c:forEach var="reward" items="${requestScope.rewards}">
			<li>
				<p>
					<a href="payment?id=${reward.id}">$${reward.amount}</a> 					
					<br>${reward.reward}
				</p>
			</li>
		</c:forEach>
	</ul>
</c:if>


<jsp:include page="footer.jsp" />