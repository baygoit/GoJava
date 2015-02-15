<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="ua.com.goit.gojava.POM.dataModel.common.*,
			ua.com.goit.gojava.POM.dataModel.profitCostSubsystem.*,
			ua.com.goit.gojava.POM.persistence.*,
			ua.com.goit.gojava.POM.persistence.abstraction.*,
			ua.com.goit.gojava.POM.presentation.*" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Office Management System</title>
</head>
<body>
	<br><b>Current cost item list</b></br>
		
    <% 
   		DataManager dataManager = new DataManager();
		GenericDAO<CostItem> genericDAO = new GenericDAO<CostItem>(CostItem.class, dataManager);
		for(CostItem costItem: genericDAO.getList()) {
			out.println("<br>"+costItem.getName()+"</br>");	
		};
			
	 %>	
	 
	<br><b>-----------------</b></br>
	
	<form name="costItemForm"
    		action="CostItemWebController"
    		method=GET>
    
	<br><b>New cost item: </b></br>
	<input name="costItem" value ="Cost item value" SIZE=20 MAXLEGNTH=20>
	<input type="submit" name="AddNew" value="Add new item">
  
  	</form> 
</body>
</html>