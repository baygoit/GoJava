<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.common.*,ua.com.goit.gojava.POM.dataModel.documents.*,
			ua.com.goit.gojava.POM.services.*,
			java.text.SimpleDateFormat,
			java.util.Currency"
						
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<script type="text/javascript">
	
	function validateData(obj){
		
		if ((obj.name == "AddNew")||(obj.name == "Edit") ) {
		    
		}
	}
	
	</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="design.css">
		<title>Project Office Management System</title>
	</head>
	<body>
		<% pageContext.setAttribute("paymentDocumentService", ApplicationContextProvider.getApplicationContext().getBean("PaymentDocumentService")); %>
		
		<div class="pageHeader">Платежные документы</div>
		
		<form name="PaymentDocumentListTable"
	    	action="PaymentDocumentWebController"
	    	method=POST>
	    	
	    	<c:if test="${errorMessage != null}">
				<table class = "errorTable">
	    			<tr>
	    				<td>${errorMessage}</td>
	    				<c:set var="errorMessage" scope="session" value = "${null}" />
	    			</tr>
	    		</table>
	    	</c:if>

			<table class = "table">
	    		<tr class="tableHeader">
	    			<th>Идентификатор</th>
	    			<th>Дата</th>
	    			<th>Банковский счет</th>
	    			<th>Валюта</th>
	    			<th>Сумма</th>
	    			<th>Подтвержден</th>
	    			<th>Описание</th>
	    		</tr>
	    		<c:if test="${pageScope.paymentDocumentService != null}" >
		   			<c:set var="paymentDocuments" scope="page" value = "${paymentDocumentService.retrieveAll()}" />
			    	<c:forEach var="currentPaymentDocument" items="${paymentDocuments}">
		   				<tr class="tableRow">
		   					<td>${currentPaymentDocument.getId()}</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${currentPaymentDocument.getDate()}" />
							</td>
							<td>${currentPaymentDocument.getBankAccount().getName()}</td>
							<td>${currentPaymentDocument.getCurrency().getCurrencyCode()}</td>
							<td class="numericColumn">${currentPaymentDocument.getDocSum().getValue()}</td>
							<td>${currentPaymentDocument.isChecked()}</td>
							<td>${currentPaymentDocument.getDescription()}</td>
							<td>
								<button class = "defaultButton" type="submit" name="DellCurrent" 
										value="${currentPaymentDocument.getId()}">Удалить</button>
								<button class = "defaultButton" type="submit" name="EditCurrent" 
										value="${currentPaymentDocument.getId()}">Открыть</button>
							</td>	
						</tr>	
		   			</c:forEach>	
		    	</c:if>
		    	<tr class="tableRow">
    				<td></td>
	    			<td></td>
	    			<td></td>
	    			<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><input class = "defaultButton" type="submit" name="AddNew" 
	    					value="Создать новый">
					</td>
		 		</tr>
		   </table>
	    </form>
	</body>
</html>