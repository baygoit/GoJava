<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param value="Asking question" name="title" />
</jsp:include>

	<div class="container">
		<c:if test = "${errors != null}">
	
			<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
				
				<legend>Errors</legend>
				
					<ul>
				
						<c:if test = "${nameError != null}">
							<li class="error"> Name error.</li>
						</c:if>
						
						<c:if test = "${questionError != null}">
							<li class="error"> Question error.</li>
						</c:if>
								
					</ul>
			
			</fieldset>
		</c:if>

		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
			<legend style="text-align: center;">ASK QUESTION</legend>
				<form action="ask" method="post">
					<table>
						<tr>
			
							<td><label for="first-name" class="inputLabel">First name : </label></td>
							<td><input name="first-name" type="text"></input></td>
			
						</tr>
						<tr>
							
							<td><label for="question" class="inputLabel">Question : </label></td>
							<td><input	name="question" type="text"></input></td>
		
						</tr>
						<tr>
							
							<td colspan="2"><input id="submitButton" type="submit" value="Ask question"></input><td>
						
						</tr>
					</table>
				</form>
		</fieldset>

	</div>
<jsp:include page="footer.jsp" />