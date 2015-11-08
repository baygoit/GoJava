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
		<% pageContext.setAttribute("projectService", ApplicationContextProvider.getApplicationContext().getBean("ProjectService")); %>
		
		<div class="pageHeader">Проекты</div>
		
		<form name="ProjectsTable"
	    	action="ProjectWebController"
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
	    			<th>Руководитель</th>
	    			<th>Тип</th>
	    			<th>Активен</th>
	    			<th>Описание</th>
	    		</tr>
	    		<c:if test="${pageScope.projectService != null}" >
	    			<c:set var="projects" scope="page" value = "${projectService.retrieveAll()}" />
		   			<c:forEach var="currentProject" items="${projects}">
		   				<tr class="tableRow">
		   					<td>${currentProject.getId()}</td>
							<td>${currentProject.getName()}</td>
							<td>${currentProject.getPm()}</td>
							<td>${currentProject.getType()}</td>
							<td>${currentProject.isActive()}</td>
							<td>${currentProject.getDescription()}</td>
							<td>
								<button class = "defaultButton" type="submit" name="DellCurrent" 
										value="${currentProject.getId()}">Удалить</button>
								<button class = "defaultButton" type="submit" name="EditCurrent" 
										value="${currentProject.getId()}">Редактировать</button>
							</td>	
						</tr>	
		   			</c:forEach>	
		    	</c:if>
		    	<tr class="tableRow">
		    		<c:choose>
		    			<c:when test="${sessionScope.currentProjectForEdit != null}" >
		    				
		    				<td>${currentProjectForEdit.getId()}</td>
			    			<td><input name="name" value= "${currentProjectForEdit.getName()}" />  </td>
			    			<td><input name="pm" value= "${currentProjectForEdit.getPm()}" />  </td>
			    			<td><select name="type" >
								  	<option selected value="${currentProjectForEdit.getType()}" > ${currentProjectForEdit.getType()} </option>
				   					<option value="INNER" > INNER </option>
					   				<option value="OUTER" > OUTER </option>
			   					</select>
							</td>
			    			<td><input type="checkbox" name="active"  checked="${currentProjectForEdit.isActive()}" />  </td>
			    			<td><input name="description" value= "${currentProjectForEdit.getDescription()}" />  </td>
			    			<td>
			    				<input class = "defaultButton" type="submit" name="Edit" value="Записать изменения">
			    				<input class = "defaultButton" type="submit" name="UndoEdit" value="Отменить">
			    			</td>
		    			</c:when>
			    		<c:otherwise >
				   			<td></td>
			    			<td><input name="name" value ="" ></td>
			    			<td><input name="pm" value ="" ></td>
			    			<td><select name="type" >
								  	<option disabled selected value="">Выберите тип</option>
			   						<option value="INNER" > INNER </option>
					   				<option value="OUTER" > OUTER </option>
			   					</select>
							</td>
							<td><input type="checkbox" name="active" checked />  </td>
			    			<td><input name="description" value= "" />  </td>
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