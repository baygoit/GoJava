<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Payment</title>
<%@ include file="html/style.html"%>
</head>
<body>
	<div class="root">
		<div class="box">
			<div class="boxCaption basecolor">Enter payment credentials</div>
			<div class="boxContent">


				<form action="project" method="post" id="submitForm">
					<input type="hidden" name="projectId"
						value="${param.project}"> <input
						type="hidden" name="rewardId"
						value="<%=request.getParameter("reward") == null ? 0 : request.getParameter("reward")%>">
					<input type="hidden" name="operation" value="payment">
					<table>
						<tr>
							<td>User:</td>
							<td><input type="text" name="user"></td>
						</tr>
						<tr>
							<td>Card ID:</td>
							<td><input type="<%="number"%>" name="cardId" min="0"></td>
						</tr>
						<tr>
							<td>Amount:</td>
							<td><input type="<%="number"%>" name="amount" min="0"></td>
						</tr>
					</table>

				</form>

				<div class="controls basecolor">
					<jsp:include page="html/Submit.html" />
					<jsp:include page="html/Back.html" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>