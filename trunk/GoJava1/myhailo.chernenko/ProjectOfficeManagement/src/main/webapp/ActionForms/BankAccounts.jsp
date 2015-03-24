<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.cash.*,
			ua.com.goit.gojava.POM.services.*,
			java.util.Currency"
			
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<script type="text/javascript">
	
	function validateData(obj){
		
		if ((obj.name == "AddNew")||(obj.name == "Update") ) {
		
		}
		
		return true;
	}
	
	</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="design.css">
		<title>Project Office Management System</title>
	</head>
	<body>
		
		<div class="pageHeader">Банковские счета</div>
		<s:actionerror class="errorTable" />
        <s:form name="BankAccountsTable" theme="simple"
			action="BankAccountList">

			<table class = "table">
	    		<tr class="tableHeader">
	    			<th>Идентификатор</th>
	    			<th>Название</th>
	    			<th>Банк</th>
	    			<th>Валюта</th>
	    			<th>Остаток</th>
	    		</tr>
	    		<s:iterator  value="bankAccounts" status="stat">
	             	<tr class="tableRow">
	   					<td><s:property value = "bankAccounts[#stat.index].getId()"/></td>
						<td><s:property value = "bankAccounts[#stat.index].getName()"/></td>
						<td><s:property value = "bankAccounts[#stat.index].getBankName()"/></td>
						<td><s:property value = "bankAccounts[#stat.index].getCurrency().getCurrencyCode()"/></td>
						<td class="numericColumn">
							<s:property value = "cashMovementService.getTotalByBankAccount(bankAccounts[#stat.index]).getValue()"/></td>
						<td>
							<button class = "defaultButton" type="submit" name="DellCurrent" 
									value= <s:property value = "bankAccounts[#stat.index].getId()"/>
									>Удалить</button>
							<button class = "defaultButton" type="submit" name="EditCurrent" 
									value= <s:property value = "bankAccounts[#stat.index].getId()"/>
									>Редактировать</button>
							<button class = "defaultButton" type="submit" name="OpenCashMovement" 
									value= <s:property value = "bankAccounts[#stat.index].getId()"/>
									>Открыть движения</button>
						</td>	
					</tr>	
		   		</s:iterator>
		    	<tr class="tableRow">
		    		<s:if test="currentAccountForEdit != null">
		    			<td><s:property value = "currentAccountForEdit.getId()"/></td>
		    			<td><s:textfield name="name" value = "%{currentAccountForEdit.getName()}" /></td>
		    			<td><s:textfield name="bankName" value = "%{currentAccountForEdit.getBankName()}" /></td>
		    			<td><s:select 
							   name="currencyCode" 
							   headerKey="" headerValue="Укажите валюту"
       						   list="currenciesMap"
						       value="%{currentAccountForEdit.getCurrency().getCurrencyCode()}"/>
						</td>
		    			<td class="numericColumn">
		    				<s:property value = "cashMovementService.getTotalByBankAccount(currentAccountForEdit).getValue()"/> 
		    			</td>
		    			<td>
							<button class = "defaultButton" type="submit" name="Update" value="true"
									>Записать изменения</button>
							<button class = "defaultButton" type="submit" name="UndoEdit" value="true"
									>Отменить</button>
						</td>
		    		</s:if>	
		    		<s:else>	
	    				<td></td>
		    			<td><s:textfield name="name" /></td>
		    			<td><s:textfield name="bankName" /></td>
		    			<td><s:select 
							   name="currencyCode" 
							   headerKey="" headerValue="Укажите валюту"
       						   list="currenciesMap"/>
						</td>
		    			<td class="numericColumn"></td>
		    			<td>
							<button class = "defaultButton" type="submit" name="AddNew" value="true"
									>Создать новый</button>
						</td>
		    		</s:else>
		 		</tr>
		   </table>
	    </s:form>
	</body>
</html>