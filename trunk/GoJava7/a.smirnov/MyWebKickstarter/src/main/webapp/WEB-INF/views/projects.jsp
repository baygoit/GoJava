<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param value="Projects" name="title" />
</jsp:include>

	<div class="container">	
		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
			<legend class="legend" style="text-align: center;">ALL PROJECTS IN SELECTED CATEGORY</legend>
				<div>
			
					<c:forEach items="${projects}" var="project">
					
						<fieldset style="border: 0">
					
							<table>
		   			 
		       		   			<tr><td>Title : </td><td><a href=project?id=${project.id}><c:out value="${project.name}"/></a></td></tr>
		       		   	
		       		  	 		<tr><td>Short description : </td><td><c:out value="${project.shortDescription}"/></td></tr>
		       		   	
		       		  	 		<tr><td>Required amount : </td><td><c:out value="${project.requiredSum}"/> USD</td></tr>
		       		   	
		       		  	 		<tr><td>Collected amount : </td><td><c:out value="${project.collectedSum}"/> USD</td></tr>
		       		   	
		       		   		</table>
		       		   	
		       		   	</fieldset>
		  			 
					</c:forEach>
			
				</div>
		</fieldset>
	</div>
<jsp:include page="footer.jsp" />