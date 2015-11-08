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
		<% pageContext.setAttribute("projectStageService", ApplicationContextProvider.getApplicationContext().getBean("ProjectStageService")); %>
		
		<div class="pageHeader">Этапы проектов</div>
		
		<form name="ProjectStagesTable"
	    	action="ProjectStageWebController"
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
	    			<th>Родитель</th>
	    			<th>Описание</th>
	    		</tr>
	    		<c:if test="${pageScope.projectStageService != null}" >
	    			<c:set var="projectStages" scope="page" value = "${projectStageService.retrieveAll()}" />
		   			<c:forEach var="currentProjectStage" items="${projectStages}">
		   				<tr class="tableRow">
		   					<td>${currentProjectStage.getId()}</td>
							<td>${currentProjectStage.getName()}</td>
							<td>${currentProjectStage.getParent().getName()}</td>
							<td>${currentProjectStage.getDescription()}</td>
							<td>
								<button class = "defaultButton" type="submit" name="DellCurrent" 
										value="${currentProjectStage.getId()}">Удалить</button>
								<button class = "defaultButton" type="submit" name="EditCurrent" 
										value="${currentProjectStage.getId()}">Редактировать</button>
							</td>	
						</tr>	
		   			</c:forEach>	
		    	</c:if>
		    	<tr class="tableRow">
		    		<c:choose>
		    			<c:when test="${sessionScope.currentProjectStageForEdit != null}" >
		    				
		    				<td>${currentProjectStageForEdit.getId()}</td>
			    			<td><input name="name" value= "${currentProjectStageForEdit.getName()}" />  </td>
			    			<td><select name="parent" >
								  	<option selected value="${currentProjectStageForEdit.getParent().getId()}" >
								  							 ${currentProjectStageForEdit.getParent().getName()} </option>
								  	<%
								  		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
				   						for(Project project: projectService.retrieveAll()) {
											out.println("<option value=" + project.getId()
														+ ">" +project.getName()+"</option>");
										};
									 %>
				   				</select>
							</td>
			    			<td><input name="description" value= "${currentProjectStageForEdit.getDescription()}" />  </td>
			    			<td>
			    				<input class = "defaultButton" type="submit" name="Edit" value="Записать изменения">
			    				<input class = "defaultButton" type="submit" name="UndoEdit" value="Отменить">
			    			</td>
		    			</c:when>
			    		<c:otherwise >
				   			<td></td>
			    			<td><input name="name" value ="" ></td>
			    			<td><select name="parent" >
								  	<option disabled selected value="">Выберите проект</option>
			   						<%
								  		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
				   						for(Project project: projectService.retrieveAll()) {
											out.println("<option value=" + project.getId()
														+ ">" +project.getName()+"</option>");
										};
									 %>
			   					</select>
							</td>
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