<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.common.*,
			ua.com.goit.gojava.POM.dataModel.cashSubsystem.*,
			ua.com.goit.gojava.POM.persistence.*,
			ua.com.goit.gojava.POM.persistence.abstraction.*,
			ua.com.goit.gojava.POM.presentation.*,
			java.util.Currency"
			
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Office Management System</title>
</head>
<body>
	<form name="BankAccountCreater"
    		action="BankAccountWebController"
    		method=POST>
	   <table border="1">
	    	<caption>Банковские счета</caption>
	    		<tr>
	    			<th>Идентификатор</th>
	    			<th>Название</th>
	    			<th>Банк</th>
	    			<th>Валюта</th>
	    			<th>Остаток</th>
	    		</tr>
	   		    <% 
			   		GenericDAO<BankAccount> genericDAO = new GenericDAO<BankAccount>(BankAccount.class,
			   					LazyDataManager.getInstance());
					for(BankAccount bankAccount: genericDAO.getList()) {
						out.println("<tr>");
						
							out.println("<td>"+bankAccount.getId()+"</td>");
							out.println("<td>"+bankAccount.getName()+"</td>");
							out.println("<td>"+bankAccount.getBankName()+"</td>");
							out.println("<td>"+bankAccount.getCurrency()+"</td>");
							out.println("<td>"+bankAccount.GetTotal()+"</td>");
							
							out.println("<td>");
								out.println("<button type=\"submit\" name=\"DellCurrent\" "+
											"value="+bankAccount.getId()+">Удалить</button>");
								out.println("<a href=\"CashMovementWebController?act=f&id="+bankAccount.getId()+"\"> Факт </a> ");
								out.println("<a href=\"CashMovementWebController?act=p&id="+bankAccount.getId()+"\"> План </a> ");
							out.println("</td>");
						
						out.println("</tr>");
					};
				 %>	
				 <tr>
	    			<td></td>
	    			<td><input name="name" value =""></td>
	    			<td><input name="bankName" value =""></td>
	    			<!-- <td><input name="currency" value =""></td>  -->
	    			<td><select name="currency">
					  	<option disabled>Выберите валюту</option>
    					<% 
							for(Currency currency: Currency.getAvailableCurrencies()) {
								out.println("<option>"+currency.getCurrencyCode()+"</option>");
							};
						%>	
						</select>
					</td>
	    			<td></td>
	    			<td><input type="submit" name="AddNew" value="Создать новый"></td>
		 		 </tr>
	   </table>
	</form> 
</body>
</html>