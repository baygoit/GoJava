<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Donate to ${project.projectName}" />
</jsp:include>

<h3><a href="index">Kickstarter</a>
/
<a href="category?categoryId=${category.categoryId}">${category.categoryName}</a></h3>
<h1><a href="project?id=${project.id}">${project.projectName}</a></h1>


         Bonuses:
        	<ul>
   	<c:forEach var="pBonus" items="${paymentBonuses}" >
   
			<li>
			 ${pBonus.amount}  - ${pBonus.bonus}
			</li>
			
		</c:forEach>
     </ul>  


<c:if test="${empty paymentBonuses}">
	<h3>There are no rewards</h3>
	<form action="payment" method="get">
	<font color=red><c:if test="${not empty message}">${message}</c:if></font >
		<br><label>I want to help the project.</label>		
		<input type="text" name="amount" value="1">
		<input type="hidden" name="projectId" value="${project.id}" />
		<input type="submit" value="Continue" />
	</form>
</c:if>

<c:if test="${not empty paymentBonuses}">
	<h3>Let's choose your reward!</h3>
	
	<form action="payment" method="get">
		<h3>No thanks, I just want to help the project.</h3>
		<font color=red><c:if test="${not empty message}">${message}</c:if></font >
		<label>Pledge amount</label>		
		<input type="text" name="amount" value="1">
		<input type="hidden" name="projectId" value="${project.id}" />
		<input type="hidden" name="rewardId" value="0" />
		<input type="submit" value="Continue" />
	</form>

	<ul>
		<c:forEach var="pBonus" items="${paymentBonuses}" >
			<li>
				<p>
					<a href="payment?rewardId=${pBonus.id}">$${pBonus.amount}</a>
					<br>${reward.reward}
					 ${pBonus.bonus}
				</p>
			</li>
		</c:forEach>
	</ul>
</c:if>


<jsp:include page="footer.jsp" />