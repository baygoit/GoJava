<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Investment" scope="request"/>
<c:set var="script" value="./js/investment.js" scope="request"/>
<jsp:include page="header.jsp"/>
		<label class="subheader">Investment</label><br/><br/>
		Project: ${project.name}<br/>
		Money left to collect: ${project.requiredSum - project.collectedSum}<br/>
		Available rewards:
		<hr/>
		<form name="add_investment" method="POST" action="" accept-charset="utf-8">
			<input type="hidden" name="action" value="add_investment">
			<input type="hidden" name="project_id" value="${project.id}">
			<c:forEach var="reward" items="${rewards}">
				<input type="radio" name="amount" value="${reward.amount}" onclick="updateCustomAmount()"/><label class="reward_amount">$ ${reward.amount}</label> - ${reward.description}<br/>
			</c:forEach>
			<input id="radio_custom" type="radio" name="amount" value="0" checked onclick="updateCustomAmount()"/>Custom amount
			<hr/>
			<label id="lb_custom_amount">Custom amount</label><br/>
			<input id="in_custom_amount" type="number" name="custom_amount" max="2147483647" min="1" value="1"/><br/>
			Cardholder name<br/>
			<input type="text" name="cardholder_name" autofocus/><br/>
			Card number<br/>
			<input type="text" name="card_number"/><br/>
			<input class="button" type="submit" value="Invest"/><br/>
		</form>
		<hr/>
		<a href="?page=project&id=${project.id}">Return</a>
<jsp:include page="footer.jsp"/>
