<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.common.*,ua.com.goit.gojava.POM.dataModel.cash.*,
			ua.com.goit.gojava.POM.persistence.*,
			ua.com.goit.gojava.POM.persistence.abstraction.*,
			ua.com.goit.gojava.POM.presentation.*,
			java.util.Currency"
						
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<script type="text/javascript">
	
	function validateData(obj){
		
		if (obj.name == "AddNew" ) {
			
			var date = this.CashMovement.date.value;
			var isDate = /[0-9]{4,4}.[0-9]{1,2}.[0-9]{1,2}/;
		    if (date == null || date == "" || !isDate.test(date) ) {
		        alert("You must fill date field by the template 'yyyy.mm.dd'!");
		        return false;
		    }
			
		    var sum = this.CashMovement.sum.value;
			//var isSum = /[0-9]{0,10}[.]{0,1}[0-9]{0,2}/;
		    if (isNaN(sum)) {
		        alert("You must fill sum field!");
		        return false;
		    }
		}
	}
	</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="design.css">
		<title>Project Office Management System</title>
	</head>
	<body>
		<form name="CashMovement"
	    		action="CashMovementWebController"
	    		method=POST
	    		onsubmit="return validateData()" >
	    
	    <div class="pageHeader">Записи о движении денег: ${sessionScope.BankAccount.getName()} 
	    				(${sessionScope.BankAccount.getCurrency().getDisplayName()})</div>
		   <input type="hidden" name="submited" value ="" >	
		   <table class = "table">
		    	
				<tr class="tableHeader">
		   			<th>Идентификатор</th>
		   			<th>Дата</th>
		   			<th>Сумма</th>
		   			<th>Характеристика</th>
		   			<th>Описание</th>
		   			<th>Документ</th>
		   		</tr>
		   		<c:if test="${sessionScope.CashMovementStatement != null}" >
		   			<c:set var="currentStatementEntries" scope="session" value = "${CashMovementStatement.getEntries()}" />
		   			<c:forEach var="currentEntry" items="${currentStatementEntries}">
		   				<tr class="tableRow">
							<td>${currentEntry.getId()}</td>
							<td>
									<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${currentEntry.getDate()}" />
								</td>
							<td class="numericColumn">${currentEntry.getSum().getValue()}</td>
							<td>${currentEntry.getCharacteristic()}</td>
							<td>${currentEntry.getDescription()}</td>
							<td>${currentEntry.getDoc()}</td>
							<td>
								<button class = "defaultButton" type="submit" name="DellCurrent" 
										onclick="return validateData(this);"
										value="${currentEntry.getId()}">Удалить</button>
								</td>							
						</tr>
		   			</c:forEach>	
		    	</c:if>
				<c:if test="${sessionScope.CashMovementStatementHolder != null}" >
		    		<tr class="tableRow">
 		    			<td></td>
 		    			<!-- this is banned html5...  
 		    				<td><input name="date" value =""  pattern="[0-9]{4}.[0-9]{1,2}.[0-9]{1,2}" ></td>
 		    				 <td class="numericColumn"><input name="sum" value ="0"  pattern="\d+(,\d{2})?" ></td>
 		    				 -->
 		    			<td><input name="date" value =""  ></td>
 		    			<td class="numericColumn"><input name="sum" value ="0" ></td>
 		    			<td><input name="characteristic" value =""></td>
 		    			<td><input name="description" value =""></td>
 		    			<td><input name="doc" value =""></td>
 		    			<td><input class = "defaultButton" type=submit name="AddNew" 
 		    							onclick="return validateData(this);"
										value ="Добавить новую"></td>
		  		    </tr>
		  		</c:if>
		   </table>
		</form> 
	</body>
</html>