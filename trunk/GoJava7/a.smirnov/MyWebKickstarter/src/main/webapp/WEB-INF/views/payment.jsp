<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param value="Payment" name="title" />
</jsp:include>

	<div class="container">
	
		<c:if test = "${errors != null}">
	
			<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
				<legend>Errors</legend>
					<ul>
					
						<c:if test = "${nameError != null}">
							<li class="error"> Name error.</li>
						</c:if>
						
						<c:if test = "${creditCardError != null}">
							<li class="error"> Credit card number invalid.</li>
						</c:if>
						
						<c:if test = "${donatingSumError != null}">
							<li class="error"> Pledge invalid.</li>
						</c:if>
						
					</ul>
			</fieldset>
		</c:if>
	

		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">

			<legend style="text-align: center;">PAYMENT</legend>

			<form action="payment" method="post">

				<table>
					<tr>
						<td><label for="first-name" class="inputLabel">First name : </label></td>

						<td><input name="first-name" type="text"></input></td>
					</tr>

					<tr>
						<td><label for="creditCardNumber" class="inputLabel">Credit	card number : </label></td>

						<td><input name="creditCardNumber" type="text"></input></td>
					</tr>
				</table>
				
				<fieldset style="border: 0">
					<table>
						<c:forEach items="${projectRewards}" var="reward">
							<tr>
								<td colspan="2">If you donate ${reward.getPledge()} USD : ${reward.getDescription()}</td>
							</tr>
						</c:forEach>

						<tr>
							<td><label for="donatingSum" class="inputLabel">Please enter pledge amount : </label></td>
	
							<td><input name="donatingSum" type="text"></input></td>
						</tr>

						<tr>
							<td colspan="2"><input id="submitButton" type="submit" value="Execute payment"></input></td>
						</tr>
						
					</table>
					
				</fieldset>
				
			</form>
			
		</fieldset>
		
	</div>
<jsp:include page="footer.jsp" />