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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="design.css">
		<title>Project Office Management System</title>
	</head>
	<body>
		
		<div class="pageHeader">Банковские счета</div>
		<s:actionerror class="errorTable" />
       	
       	<s:form name="Editor" action="BankAccountSaver" class = "table">
	   				<s:textfield  name="idInfo" 
	    					class="tableRow"
	    					label = "Идентификатор"
	    					value = "%{bankAccount.id}"
	    					readonly = "true"
	    				/> 
	   				<s:textfield name="name" 
	    					label = "Название"
	    					value = "%{bankAccount.name}"
	    				 /> 
	    			<s:textfield name="bankName" 
	    					label = "Банк"
	    					value = "%{bankAccount.bankName}"
	    			 	/> 
	    			<s:select name="currencyCode" 
						   label = "Валюта"
    					   headerKey="" headerValue="Укажите валюту"
      						   list="currenciesMap"
					       	   value="%{bankAccount.currency.currencyCode}"
						 />
					<s:submit class = "defaultButton" type="button" 
							name= "id" 
							value= "%{bankAccount.id}"
							label = "Сохранить"
						 />
					<s:submit class = "defaultButton" type="button" 
							name="cancel" 
							value= "true"
							label = "Отменить" 
						/>
		</s:form>
	    		
	</body>
</html>