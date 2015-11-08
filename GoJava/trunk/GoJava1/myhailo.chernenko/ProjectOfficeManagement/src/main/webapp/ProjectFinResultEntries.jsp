<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.common.*,ua.com.goit.gojava.POM.dataModel.profitcost.*,
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
			
			var date = this.CashMovementTable.date.value;
			var isDate = /[0-9]{4,4}-[0-9]{1,2}-[0-9]{1,2}/;
		    if (date == null || date == "" || !isDate.test(date) ) {
		        alert("You must fill Date field by the template 'yyyy-mm-dd'!");
		        return false;
		    }
			
		    var rate = this.CashMovementTable.sum.value;
			//var isSum = /[0-9]{0,10}[.]{0,1}[0-9]{0,2}/;
		    if (isNaN(rate)) {
		        alert("You must fill Sum field!");
		        return false;
		    }
		    
		}
	}
	
	function setCurrency(){
		
		var bankAccountId = this.CashMovementTable.bankAccount.value;
		this.CashMovementTable.currency.value = bankAccountCurrencies[bankAccountId];	
		
	}
	
	</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="design.css">
		<title>Project Office Management System</title>
	</head>
	<body>
		<% pageContext.setAttribute("projectFinResultEntryService", ApplicationContextProvider.getApplicationContext().getBean("ProjectFinResultEntryService")); %>
			
		<div class="pageHeader">Записи о затратах проектов</div>
		
		<form name="ProjectFinResulTable"
	    	action="ProjectFinResultWebController"
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
	    			<th>Тип</th>
	    			<th>Проект</th>
	    			<th>Этап</th>
	    			<th>Статья</th>
	    			<th>Валюта</th>
	    			<th>Сумма</th>
	    		</tr>
	    		<c:if test="${pageScope.projectFinResultEntryService != null}" >
		   			<c:set var="projectFinResultEntries" scope="page" value = "${projectFinResultEntryService.retrieveAll()}" />
			    	<c:forEach var="currentEntry" items="${projectFinResultEntries}">
		   				<tr class="tableRow">
		   					<td>${currentEntry.getId()}</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${currentEntry.getDate()}" />
							</td>
							<td>${currentEntry.getType()}</td>
							<td>${currentEntry.getProject().getName()}</td>
							<td>${currentEntry.getProjectStage().getName()}</td>
							<td>${currentEntry.getCostItem().getName()}</td>
							<td>${currentEntry.getCurrency().getCurrencyCode()}</td>
							<td class="numericColumn">${currentEntry.getSum().getValue()}</td>
							<td>
								<button class = "defaultButton" type="submit" name="DellCurrent" 
										value="${currentEntry.getId()}">Удалить</button>
								<button class = "defaultButton" type="submit" name="EditCurrent" 
										value="${currentEntry.getId()}">Редактировать</button>
							</td>	
						</tr>	
		   			</c:forEach>	
		    	</c:if>
		    	<tr class="tableRow">
		    		<c:choose>
		    			<c:when test="${sessionScope.currentEntryForEdit != null}" >
		    				
		    				<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${currentEntryForEdit.getDate()}" var = "stringDate" />
		    				<td>${currentEntryForEdit.getId()}</td>
			    			<td><input name="date" value= "${stringDate}" />  </td>
			    			<td><select name="type" >  
				    				<option selected value="${currentEntryForEdit.getType()}" > ${currentEntryForEdit.getType()} </option>
				   					<option value="PROFIT" > PROFIT </option>
				   					<option value="LOSTS" > LOSTS </option>
			   					</select>
			    			</td>
			    			<td><select name="project" >
							  	<option selected value="${currentEntryForEdit.getProject().getId()}" >
							  							${currentEntryForEdit.getProject().getName()}
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
							  	<option selected value="${currentEntryForEdit.getProjectStage().getId()}" >
							  							${currentEntryForEdit.getProjectStage().getName()}
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
							  	<option selected value="${currentEntryForEdit.getCostItem().getId()}" >
							  							${currentEntryForEdit.getCostItem().getName()}
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
							  	<option selected value="${currentEntryForEdit.getCurrency().getCurrencyCode()}" >
							  							${currentEntryForEdit.getCurrency().getCurrencyCode()}
							  				</option>
			   						<%
				   						for(Currency currency: Currency.getAvailableCurrencies()) {
											out.println("<option>"+currency.getCurrencyCode()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td class="numericColumn"> <input name="sum" value = "${currentEntryForEdit.getSum().getValue()}"> </td>
			    			<td>
			    				<input class = "defaultButton" type="submit" name="Edit" value="Записать изменения">
			    				<input class = "defaultButton" type="submit" name="UndoEdit" value="Отменить">
			    			</td>
		    			</c:when>
			    		<c:otherwise >
				   			<td></td>
			    			<td><input name="date" value ="" ></td>
			    			<td><select name="type" >  
				    				<option selected value="${currentEntryForEdit.getType()}" > ${currentEntryForEdit.getType()} </option>
				   					<option value="PROFIT" > PROFIT </option>
				   					<option value="LOSTS" > LOSTS </option>
			   					</select>
			    			</td>
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
			    			<td><input class = "defaultButton" type="submit" name="AddNew" 
			    					onclick="return validateData(this);"
									value="Создать новый">
							</td>
			    		</c:otherwise>
			    	</c:choose>
		 		</tr>
		   </table>
	    </form>
	</body>
</html>