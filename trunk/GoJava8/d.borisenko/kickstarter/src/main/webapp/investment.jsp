<%@include file='header.jsp'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<label class="subheader">Investment</label><br/><br/>
		Project: ${project.name}<br/>
		Money left to collect: ${project.requiredSum - project.collectedSum}<br/>
		Available rewards:
		<hr/>
		<form name='add_investment' method='POST' action='' accept-charset='utf-8'>
			<input type='hidden' name='requested_action' value='ADD_INVESTMENT'>
			<input type='hidden' name='project_id' value='${project.id}'>
			<c:forEach var="reward" items="${rewards}">
				<input type='radio' name='amount' value='${reward.amount}'/><label class="reward_amount">$ ${reward.amount}</label> - ${reward.description}<br/>
			</c:forEach>
			<input type='radio' name='amount' value='0' checked/>Custom amount
			<hr/>
			Custom amount<br/>
			<input type='number' name='custom_amount' value='0'/><br/>
			Cardholder name<br/>
			<input type='text' name='cardholder_name'/><br/>
			Card number<br/>
			<input type='text' name='card_number'/><br/>
			<input class='button' type='submit' value='Invest'/><br/>
		</form>
		<hr/>
		<a href='?page=project&id=${project.id}'>Return</a>
<%@include file='footer.jsp'%>
