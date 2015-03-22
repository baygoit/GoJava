<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.common.*,ua.com.goit.gojava.POM.dataModel.documents.*,
			ua.com.goit.gojava.POM.dataModel.cash.*, ua.com.goit.gojava.POM.dataModel.profitcost.*,
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
		<%  BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
			pageContext.setAttribute("bankAccountService", bankAccountService ); %>
		<%  PaymentDocumentService paymentDocumentService = ApplicationContextProvider.getApplicationContext().getBean(PaymentDocumentService.class);
			pageContext.setAttribute("paymentDocumentService", paymentDocumentService); %>
		
		<c:choose>
		    <c:when test="${sessionScope.currentPaymentDocumentForEdit.getId() != 0}" >
		    	<div class="pageHeader">Платежный документ номер "${currentPaymentDocumentForEdit.getId()}"</div>
		    </c:when>
			<c:otherwise >
				<div class="pageHeader">Платежный документ (создание нового)</div>
			</c:otherwise>
		</c:choose>
			    	
		
		<form name="PaymentDocumentTable"
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
				
				<tr>
	    			<td class="tableHeader">Дата</td>
	    				<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${currentPaymentDocumentForEdit.getDate()}" var = "stringDate" />
		    		<td><input name="date" value= "${stringDate}" />  </td>
			    	<td class="tableHeader">Подтвержден</td>
	    			<td>${currentPaymentDocumentForEdit.isChecked()}</td>
				</tr>
			    <tr>
	    			<td class="tableHeader">Банковский счет</td>
	    			<td><select name="bankAccount" onchange="setCurrency();" >
					  	<option selected value="${currentPaymentDocumentForEdit.getBankAccount().getId()}" >
					  							${currentPaymentDocumentForEdit.getBankAccount().getName()}
					  				</option>
	   						<%
	   							for(BankAccount bankAccount: bankAccountService.retrieveAll()) {
									out.println("<option "
											+" value =\""+bankAccount.getId() +"\">"
											+  bankAccount.getName()+"</option>");
								};
							 %>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td class="tableHeader">Сумма документа: </td>
	    			<td class="numericColumn">${currentPaymentDocumentForEdit.getDocSum()}</td>
				</tr>
	    		<tr>
	    			<td class="tableHeader">Описание: </td>
	    			<td> <input name="description" value= "${currentPaymentDocumentForEdit.getDescription()}" /> </td>
	    		</tr>
	    	</table>
	    	
	    	<div class="pageHeader">Детали документа:</div>
	    	
			<table class = "table">
	    		<tr class="tableHeader">
	    			<th>Идентификатор</th>
	    			<th>Номер строки</th>
	    			<th>Проект</th>
	    			<th>Этап</th>
	    			<th>Статья затрат</th>
	    			<th>Валюта</th>
	    			<th>Сумма</th>
	    		</tr>
	    		<c:set var="paymentDocumentDetails" scope="page"
	    			   value = "${currentPaymentDocumentForEdit.getPaymentDocumentDetails()}" />
				<c:if test="${paymentDocumentDetails != null}" >
		   		    <c:forEach var="currentDetail" items="${paymentDocumentDetails}">
		   				<c:if test="${currentDetail.isMarkedForDelete() == false}" >
		   					<tr class="tableRow">
			   					<td>${currentDetail.getId()}</td>
								<td>${currentDetail.getRowNumber()}</td>
								<td>${currentDetail.getProject().getName()}</td>
								<td>${currentDetail.getProjectStage().getName()}</td>
								<td>${currentDetail.getCostItem().getName()}</td>
								<td>${currentDetail.getCurrency().getCurrencyCode()}</td>
								<td class="numericColumn">${currentDetail.getSum().getValue()}</td>
								<td>
									<button class = "defaultButton" type="submit" name="DellCurrentDetail" 
											value="${currentDetail.getId()}">Удалить</button>
									<button class = "defaultButton" type="submit" name="EditCurrentDetail" 
											value="${currentDetail.getId()}">Редактировать</button>
								</td>	
							</tr>
						</c:if>	
		   			</c:forEach>
	   			</c:if>
		    	
	   			<tr class="tableRow">
		    		<c:choose>
		    			<c:when test="${sessionScope.currentDocDetailForEdit != null}" >
		    				
		    				<td>${currentDocDetailForEdit.getId()}</td>
							<td>${currentDocDetailForEdit.getRowNumber()}</td>
							<td><select name="project" >
							  	<option selected value="${currentDocDetailForEdit.getProject().getId()}" >
							  							${currentDocDetailForEdit.getProject().getName()}
							  				</option>
			   						<%
			   							ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
			   							for(Project project: projectService.retrieveAll()) {
											out.println("<option "
													+" value =\""+project.getId() +"\">"
													+  project.getName()+"</option>");
										};
									 %>
								</select>
							</td>
							<td><select name="projectStage" >
							  	<option selected value="${currentDocDetailForEdit.getProjectStage().getId()}" >
							  							${currentDocDetailForEdit.getProjectStage().getName()}
							  				</option>
			   						<%
			   							ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
			   							for(ProjectStage projectStage: projectStageService.retrieveAll()) {
											out.println("<option "
													+" value =\""+projectStage.getId() +"\">"
													+  projectStage.getName()+"</option>");
										};
									 %>
								</select>
							</td>
							<td><select name="costItem" >
							  	<option selected value="${currentDocDetailForEdit.getCostItem().getId()}" >
							  							${currentDocDetailForEdit.getCostItem().getName()}
							  				</option>
			   						<%
			   							CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
			   							for(CostItem costItem: costItemService.retrieveAll()) {
											out.println("<option "
													+" value =\""+costItem.getId() +"\">"
													+  costItem.getName()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td><select name="currency" >
							  	<option selected value="${currentDocDetailForEdit.getCurrency().getCurrencyCode()}" >
							  							${currentDocDetailForEdit.getCurrency().getCurrencyCode()}
							  				</option>
			   						<%
				   						for(Currency currency: Currency.getAvailableCurrencies()) {
											out.println("<option>"+currency.getCurrencyCode()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td class="numericColumn"> <input name="sum" value = "${currentDocDetailForEdit.getSum().getValue()}"> </td>
			    			<td>
			    				<input class = "defaultButton" type="submit" name="EditDocDetail" value="Записать изменения">
			    				<input class = "defaultButton" type="submit" name="UndoEditDocDetail" value="Отменить">
			    			</td>
		    			</c:when>
			    		<c:otherwise >
				   			<td></td>
			    			<td></td>
			    			<td><select name="project" >
							  	<option disabled selected value="" > Укажите проект</option>
			   						<%
			   							ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
			   							for(Project project: projectService.retrieveAll()) {
											out.println("<option "
													+" value =\""+project.getId() +"\">"
													+  project.getName()+"</option>");
										};
									 %>
								</select>
							</td>
							<td><select name="projectStage" >
							  	<option disabled selected value="" > Укажите этап</option>
			   						<%
			   							ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
			   							for(ProjectStage projectStage: projectStageService.retrieveAll()) {
											out.println("<option "
													+" value =\""+projectStage.getId() +"\">"
													+  projectStage.getName()+"</option>");
										};
									 %>
								</select>
							</td>
							<td><select name="costItem" >
							  	<option disabled selected value="" > Укажите статью затрат</option>
			   						<%
			   							CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
			   							for(CostItem costItem: costItemService.retrieveAll()) {
											out.println("<option "
													+" value =\""+costItem.getId() +"\">"
													+  costItem.getName()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td><select name="currency" >
							  	<option disabled selected value="" > Укажите валюту</option>
			   						<%
				   						for(Currency currency: Currency.getAvailableCurrencies()) {
											out.println("<option>"+currency.getCurrencyCode()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td class="numericColumn"> <input name="sum" value = "0"> </td>
			    			<td><input class = "defaultButton" type="submit" name="AddNewDetail" 
			    					onclick="return validateData(this);"
									value="Создать новый">
							</td>
			    		</c:otherwise>
			    	</c:choose>
		 		</tr>
		   </table>
		   <table>
		   		<tr class="tableRow">
   					<td>
						<button class = "defaultButton" type="submit" name="SaveDoc" 
								value="${currentPaymentDocumentForEdit.getId()}">Сохранить документ</button>
					</td>	
					<td>
						<button class = "defaultButton" type="submit" name="Cancel" 
								value="${currentPaymentDocumentForEdit.getId()}">Отменить редактирование</button>
					</td>
					<td>
						<button class = "defaultButton" type="submit" name="ToDocList" 
								value="${currentPaymentDocumentForEdit.getId()}">В список документов (без сохранения)</button>
					</td>	
				</tr>	
		   </table>
	    </form>
	</body>
</html>