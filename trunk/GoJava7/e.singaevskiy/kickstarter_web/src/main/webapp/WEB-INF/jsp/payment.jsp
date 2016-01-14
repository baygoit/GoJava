
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>

<springform:form action="submitpayment/${param.projectId}/${param.rewardId}" method="post" id="submitForm" modelAttribute="payment"
	class="form-horizontal">
	<input type="hidden" name="projectId" value="${param.projectId}">
	<input type="hidden" name="rewardId"
		value="<%=request.getParameter("rewardId") == null ? 0 : request.getParameter("rewardId")%>">
	<input type="hidden" name="operation" value="payment">

	<div class="form-group">
		<label class="col-sm-3 control-label">User</label>
		<div class="col-sm-6">
			<springform:input class="form-control" type="text" name="user" path="user"
				placeholder="Your name here"/>
			<springform:errors path="user"/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Card ID</label>
		<div class="col-sm-6">
			<springform:input class="form-control" type="number" name="cardId" min="0" path="cardId"
				placeholder="123456789"/>
			<springform:errors path="cardId"/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Amount</label>
		<div class="col-sm-6">
			<springform:input class="form-control" type="number" name="amount" min="0" path="sum"
				placeholder="0" value="${amount}"/>
			<springform:errors path="sum"/>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-6">
			<button type="submit" class="btn btn-primary">Send</button>
		</div>
	</div>

</springform:form>

