<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.cash.*,
			ua.com.goit.gojava.POM.services.*,
			java.util.Currency"
			
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
 

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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="design.css">
		<title>Project Office Management System</title>
	</head>
	<body>
		
		<div class="pageHeader">Банковские счета</div>
		<s:actionerror class="errorTable" />
		
		<s:form name="paginatorPanel" theme="simple" action= "BankAccountList" >
			<jsp:include page="/Paginator.jsp" />
		</s:form>
		
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
   					<td><s:property value = "bankAccounts[#stat.index].id"/></td>
					<td><s:property value = "bankAccounts[#stat.index].name"/></td>
					<td><s:property value = "bankAccounts[#stat.index].bankName"/></td>
					<td><s:property value = "bankAccounts[#stat.index].currency.currencyCode"/></td>
					<td class="numericColumn">
						<s:property value = "cashMovementService.getTotalByBankAccount(bankAccounts[#stat.index]).getValue()"/></td>
					<td>
						<s:form name="DellCurrent" theme="simple" action="BankAccountDeleter">
		   					<button class = "defaultButton" type="submit" name="id" 
									value= <s:property value = "bankAccounts[#stat.index].id"/>
									>Удалить</button>
						</s:form>
					</td>
					<td>
						<s:form name="EditCurrent" theme="simple" action="BankAccountEditorLoader">
		   					<button class = "defaultButton" type="submit" name="id" 
									value= <s:property value = "bankAccounts[#stat.index].id"/>
									>Редактировать</button>
						</s:form>
					</td>
					<td>
						<s:form name="OpenCashMovement" theme="simple" action="CashMovementList">
		   					<button class = "defaultButton" type="submit" name="bankAccountId" 
									value= <s:property value = "bankAccounts[#stat.index].id"/>
									>Открыть движения</button>
						</s:form>
					</td>	
				</tr>	
	   		</s:iterator>
	   		<tr class="tableRow">
   				<td> </td>
				<td> </td>
				<td> </td>
				<td> </td>
				<td> </td>
				<td>
					<s:form name="Create" theme="simple" action="BankAccountCreatorLoader">
	   					<button class = "defaultButton" type="submit">Добавить</button>
					</s:form>
				</td>
			</tr>		
	   </table>
	</body>
</html>