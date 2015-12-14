<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
		<ol class="breadcrumb">
		  <li><a href="./">Kickstarter</a></li>
		  <li class="active">${categoryName}</li>
		</ol>
		<ul>
			<c:forEach var="project" items="${projects}">
				<li><a href="./project?id=${project.getIdProject()}">${project.getProjectName()}</a>
				<ul>
					<c:forEach var="project" items="${projects}">
						<li>Description: ${project.getProjectShortDescription()}</li>
						<li>Costs need: ${project.getProjectCostNeed()}</li>
						<li>Costs collected: ${payments.getSummaryProjectCostsCollected(project.getIdProject())}</li>
						<li>Days left: ${project.getProjectDaysLeft()}</li>					
					</c:forEach>
				</ul>
			</li>
			</c:forEach>
		</ul>
<jsp:include page="footer.jsp" />