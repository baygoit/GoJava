<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.common.*,
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
			
			var date = this.ExchangeRatesTable.date.value;
			var isDate = /[0-9]{4,4}-[0-9]{1,2}-[0-9]{1,2}/;
		    if (date == null || date == "" || !isDate.test(date) ) {
		        alert("You must fill date field by the template 'yyyy-mm-dd'!");
		        return false;
		    }
			
		    var rate = this.ExchangeRatesTable.rate.value;
			//var isSum = /[0-9]{0,10}[.]{0,1}[0-9]{0,2}/;
		    if (isNaN(rate)) {
		        alert("You must fill Rate field!");
		        return false;
		    }
		    
		    var multiplicity = this.ExchangeRatesTable.multiplicity.value;
			//var isSum = /[0-9]{0,10}[.]{0,1}[0-9]{0,2}/;
		    if (isNaN(multiplicity)) {
		        alert("You must fill Multiplicity field!");
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
		<% pageContext.setAttribute("exchangeRateService", ApplicationContextProvider.getApplicationContext().getBean("ExchangeRateService")); %>
		
		<div class="pageHeader">Курсы валют</div>
		
		<form name="ExchangeRatesTable"
	    	action="ExchangeRateWebController"
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
	    			<th>Из валюты</th>
	    			<th>В валюту</th>
	    			<th>Курс</th>
	    			<th>Кратность</th>
	    		</tr>
	    		<c:if test="${pageScope.exchangeRateService != null}" >
		   			<c:set var="exchangeRates" scope="page" value = "${exchangeRateService.retrieveAll()}" />
		   			<c:forEach var="currentRate" items="${exchangeRates}">
		   				<tr class="tableRow">
		   					<td>${currentRate.getId()}</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${currentRate.getDate()}" />
							</td>
							<td>${currentRate.getFromCurrency().getCurrencyCode()}</td>
							<td>${currentRate.getToCurrency().getCurrencyCode()}</td>
							<td class="numericColumn">${currentRate.getRate()}</td>
							<td class="numericColumn">${currentRate.getMultiplicity()}</td>
							<td>
								<button class = "defaultButton" type="submit" name="DellCurrent" 
										value="${currentRate.getId()}">Удалить</button>
								<button class = "defaultButton" type="submit" name="EditCurrent" 
										value="${currentRate.getId()}">Редактировать</button>
							</td>	
						</tr>	
		   			</c:forEach>	
		    	</c:if>
		    	<tr class="tableRow">
		    		<c:choose>
		    			<c:when test="${sessionScope.currentRateForEdit != null}" >
		    				
		    				<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${currentRateForEdit.getDate()}" var = "stringDate" />
		    				<td>${currentRateForEdit.getId()}</td>
			    			<td><input name="date" value= "${stringDate}" />  </td>
			    			<td><select name="fromCurrency" >
							  	<option selected value="${currentRateForEdit.getFromCurrency().getCurrencyCode()}" >
							  							${currentRateForEdit.getFromCurrency().getCurrencyCode()}
							  				</option>
			   						<%
				   						for(Currency currency: Currency.getAvailableCurrencies()) {
											out.println("<option>"+currency.getCurrencyCode()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td><select name="toCurrency" >
							  	<option selected value="${currentRateForEdit.getToCurrency().getCurrencyCode()}" >
							  							${currentRateForEdit.getToCurrency().getCurrencyCode()}
							  				</option>
			   						<%
				   						for(Currency currency: Currency.getAvailableCurrencies()) {
											out.println("<option>"+currency.getCurrencyCode()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td class="numericColumn"> <input name="rate" value = "${currentRateForEdit.getRate()}"> </td>
			    			<td class="numericColumn"> <input name="multiplicity" value = "${currentRateForEdit.getMultiplicity()}"> </td>
			    			<td>
			    				<input class = "defaultButton" type="submit" name="Edit" value="Записать изменения">
			    				<input class = "defaultButton" type="submit" name="UndoEdit" value="Отменить">
			    			</td>
		    			</c:when>
			    		<c:otherwise >
				   			<td></td>
			    			<td><input name="date" value ="" ></td>
			    			<td><select name="fromCurrency" >
							  	<option disabled selected value="">Выберите валюту</option>
			   						<%
				   						for(Currency currency: Currency.getAvailableCurrencies()) {
											out.println("<option>"+currency.getCurrencyCode()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td><select name="toCurrency" >
							  	<option disabled selected value="">Выберите валюту</option>
			   						<%
				   						for(Currency currency: Currency.getAvailableCurrencies()) {
											out.println("<option>"+currency.getCurrencyCode()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td class="numericColumn"> <input name="rate" value = 0> </td>
			    			<td class="numericColumn"> <input name="multiplicity" value = 0> </td>
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