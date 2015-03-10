<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.POM.dataModel.profitcost.*,
			ua.com.goit.gojava.POM.services.*"
			 
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<script type="text/javascript">
	
	function validateData(obj){
		
		if ((obj.name == "AddNew")||(obj.name == "Edit") ) {
			
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
		<% pageContext.setAttribute("costItemService", ApplicationContextProvider.getApplicationContext().getBean("CostItemService")); %>
		
		<div class="pageHeader">Статьи затрат</div>
		
		<form name="CostItemsTable"
	    		action="CostItemWebController"
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
	    			<th>Название</th>
	    			<th>Вид</th>
	    			<th>Родитель</th>
	    		</tr>
	    		<c:if test="${pageScope.costItemService != null}" >
	    			<c:set var="costItems" scope="page" value = "${costItemService.retrieveAll()}" />
		   			<c:forEach var="currentCostItem" items="${costItems}">
		   				<tr class="tableRow">
		   					<td>${currentCostItem.getId()}</td>
							<td>${currentCostItem.getName()}</td>
							<td>${currentCostItem.getType()}</td>
							<td>${currentCostItem.getParent().getName()}</td>
							<td>
								<button class = "defaultButton" type="submit" name="DellCurrent" 
										value="${currentCostItem.getId()}">Удалить</button>
								<button class = "defaultButton" type="submit" name="EditCurrent" 
										value="${currentCostItem.getId()}">Редактировать</button>
							</td>	
						</tr>	
		   			</c:forEach>	
		    	</c:if>
		    	<tr class="tableRow">
		    		<c:choose>
		    			<c:when test="${sessionScope.currentCostItemForEdit != null}" >
		    				
		    				<td>${currentCostItemForEdit.getId()}</td>
			    			<td><input name="name" value= "${currentCostItemForEdit.getName()}" />  </td>
			    			<td><select name="type" >  
				    				<option selected value="${currentCostItemForEdit.getType()}" > ${currentCostItemForEdit.getType()} </option>
				   					<option value="PROFIT" > PROFIT </option>
				   					<option value="LOSTS" > LOSTS </option>
			   					</select>
			    			</td>
			    			<td><select name="parentId" >
							  	<option selected value="${currentCostItemForEdit.getParent().getId()}" >
							  							${currentCostItemForEdit.getParent().getName()}
							  				</option>
			   						<%
			   							CostItemService costItemService = (CostItemService) ApplicationContextProvider.getApplicationContext().getBean("CostItemService");
				   						for(CostItem costItem: costItemService.retrieveAll()) {
											out.println("<option value=" + costItem.getId()
														+ ">" +costItem.getName()+"</option>");
										};
									 %>
								</select>
							</td>
			    			<td>
			    				<input class = "defaultButton" type="submit" name="Edit" value="Записать изменения">
			    				<input class = "defaultButton" type="submit" name="UndoEdit" value="Отменить">
			    			</td>
		    			</c:when>
			    		<c:otherwise >
				   			<td></td>
			    			<td><input name="name" value ="" ></td>
			    			<td><select name="type" >  
				    				<option disabled selected value="">Выберите тип статьи</option>
			   						<option value="PROFIT" > PROFIT </option>
				   					<option value="LOSTS" > LOSTS </option>
			   					</select>
			    			</td>
			    			<td><select name="parentId" >
							  	<option disabled selected value="0"></option>
			   						<%
			   							CostItemService costItemService = (CostItemService) ApplicationContextProvider.getApplicationContext().getBean("CostItemService");
				   						for(CostItem costItem: costItemService.retrieveAll()) {
											out.println("<option value=" + costItem.getId()
														+ ">" +costItem.getName()+"</option>");
										};
									 %>
								</select>
							</td>
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