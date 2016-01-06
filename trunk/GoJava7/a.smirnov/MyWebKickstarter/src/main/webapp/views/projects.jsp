<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param value="Projects" name="title" />
</jsp:include>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-6">	
			<c:forEach items="${projects}" var="project">	
				<fieldset>			 
					<br>Project: <a href=project?id=${project.id}><c:out value="${project.name}" /></a>	 
					<ul>     		   	
						<li><b>Short description</b> <c:out value="${project.shortDescription}" /></li>
						<li><b>Required amount</b>   <c:out value="${project.requiredSum}" /> USD</li>
						<li><b>Collected amount</b>  <c:out value="${project.collectedSum}" /> USD</li>
			    	</ul>
				</fieldset>
			</c:forEach>
		</div>
	</div>
<jsp:include page="footer.jsp" />