<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="error.jsp" />

<form action="project" method="post" id="submitForm"
	class="form-horizontal">
	<input type="hidden" name="projectId" value="${param.projectId}">
	<input type="hidden" name="rewardId"
		value="<%=request.getParameter("rewardId") == null ? 0 : request.getParameter("rewardId")%>">
	<input type="hidden" name="operation" value="payment">

	<div class="form-group">
		<label class="col-sm-3 control-label">User</label>
		<div class="col-sm-6">
			<input class="form-control" type="text" name="user"
				placeholder="Your name here">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Card ID</label>
		<div class="col-sm-6">
			<input class="form-control" type="number" name="cardId" min="0"
				placeholder="123456789">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Amount</label>
		<div class="col-sm-6">
			<input class="form-control" type="number" name="amount" min="0"
				placeholder="0" value="${amount}">
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-6">
			<button type="submit" class="btn btn-primary">Send</button>
		</div>
	</div>

</form>

