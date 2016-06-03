<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Investment" scope="request"/>
<%@include file='header.jsp'%>
		<label class="subheader">Investment</label><br/><br/>
		Project: ${project.name}<br/>
		Money left to collect: ${project.requiredSum - project.gatheredBudget}<br/>
		Available rewards:
		<c:forEach var="reward" items="${project.rewards}">
			<br>description: ${reward.description}
			<br>amount:  ${reward.amount} 
			
		</c:forEach>
		<hr/>
		<form name='add_investment' method='POST' action='' accept-charset='utf-8'>
			<input type='hidden' name='requested_action' value='ADD_INVESTMENT'>
			<input type='hidden' name='project_id' value='${project.id}'>
			<c:forEach var="reward" items="${rewards}">
				<input type='radio' name='amount' value='${reward.amount}'/><label > ${reward.amount}</label> - ${reward.description}<br/>
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
		<a href="/kickstarter/project/${project.id}">Back to project</a><br>
		<a href="/kickstarter/category/${project.category.id}">Back to category</a><br>
		<a href='/kickstarter'>Back to main page</a>
		<%@include file='footer.jsp'%>