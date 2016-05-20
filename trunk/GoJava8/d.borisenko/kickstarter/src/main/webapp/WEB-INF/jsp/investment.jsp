<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<c:set var="title" scope="request">
	<spring:message code="investment.investment" />
</c:set>
<c:set var="script" value="/kickstarter/js/investment.js" scope="request"/>
<jsp:include page="header.jsp"/>
		<iframe src="<c:url value="/quote" />" width="600" height="60" frameborder="no"></iframe>
		<hr/>
		<label class="subheader"><spring:message code="investment.investment" /></label><br/><br/>
		<spring:message code="investment.project" />: ${project.name}<br/>
		<spring:message code="investment.moneyLeft" />: ${project.requiredSum - project.collectedSum}<br/>
		<spring:message code="investment.rewards" />:
		<hr/>
		<form:form method="post" commandName="investment" accept-charset="utf-8">
			
			<c:forEach var="reward" items="${project.rewards}">
				<input type="button" class="button" name="reward" onclick="setAmount(${reward.amount})" value="<spring:message code="investment.getReward" />"/><label class="reward_amount">$ ${reward.amount}</label> - ${reward.description}<br/>
			</c:forEach>
			<hr/>
			<label id="lb_amount"><spring:message code="investment.amount" /></label><br/>
			<input id="in_amount" type="number" name="amount" max="2147483647" min="1" value="1"/><br/>
			<form:errors path="amount" cssClass="error" element="div"/>
			<spring:message code="investment.cardHolderName" /><br/>
			<input type="text" name="cardHolderName" autofocus/><br/>
			<form:errors path="cardHolderName" cssClass="error" element="div"/>
			<spring:message code="investment.cardNumber" /><br/>
			<input type="text" name="cardNumber"/><br/>
			<form:errors path="cardNumber" cssClass="error" element="div"/>
			<input class="button" type="submit" value="<spring:message code="investment.invest" />"/><br/>
		</form:form>
		<hr/>
		<a href="<c:url value="/project/${project.id}" />"><spring:message code="common.returnLink" /></a>
<jsp:include page="footer.jsp"/>
