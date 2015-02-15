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
	<form name="CashMovement"
    		action="CashMovementWebController"
    		method=POST>
	   <table border="1">
	    	<% 
	    		String bankAccountName = ((BankAccount) request.getSession().getAttribute("BankAccount")).getName();
	    		out.println("<caption>Записи о движении денег: "+bankAccountName+"</caption>");
	    	%>
	    		<tr>
	    			<th>Идентификатор</th>
	    			<th>Дата</th>
	    			<th>Сумма</th>
	    			<th>Характеристика</th>
	    			<th>Описание</th>
	    			<th>Документ</th>
	    		</tr>
	   		    <% 
	   		    	CashMovementStatement currentStatement = (CashMovementStatement) request.getSession().getAttribute("CashMovementStatement");
	   		    	if (currentStatement != null) {
				   		for(CashMovementEntry currentEntry: currentStatement.getEntries()) {
							out.println("<tr>");
							out.println("<td>"+currentEntry.getId()+"</td>");
							out.println("<td>"+currentEntry.getDate()+"</td>");
							out.println("<td>"+currentEntry.getSum()+"</td>");
							out.println("<td>"+currentEntry.getCharacteristic()+"</td>");
							out.println("<td>"+currentEntry.getDescription()+"</td>");
							out.println("<td>"+currentEntry.getDoc()+"</td>");
							
							out.println("<td>");
							out.println("<button type=\"submit\" name=\"DellCurrent\" "+
											"value="+currentEntry.getId()+">Удалить</button>");
							out.println("</td>");
							
							out.println("</tr>");
						};
	   		    	}
	   		    	
	   		    	CashMovementStatement holderStatement = (CashMovementStatement) request.getSession().getAttribute("CashMovementStatementHolder");
	   		    	if (currentStatement != null) {
	   		    		
	   		    		out.println("<tr>");
	   		    				out.println("<td></td>");
	   		    				out.println("<td><input name=\"date\" value =\"\"  pattern=\"[0-9]{4}.[0-9]{1,2}.[0-9]{1,2}\" ></td>");
	   		    				out.println("<td><input name=\"sum\" value =\"\"></td>");
	   		    				out.println("<td><input name=\"characteristic\" value =\"\"></td>");
	   		    				out.println("<td><input name=\"description\" value =\"\"></td>");
	   		    				out.println("<td><input name=\"doc\" value =\"\"></td>");
	   		    				out.println("<td><input type=submit name=\"AddNew\" value =\"Добавить новую\"></td>");
	   		    		out.println("</tr>");
	   		    		
	   		    	}
				 %>	
				 
	   </table>
	</form> 
</body>
</html>