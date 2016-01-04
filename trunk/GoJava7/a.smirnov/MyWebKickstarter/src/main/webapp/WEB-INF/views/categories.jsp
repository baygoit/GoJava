<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param value="Main page" name="title" />
</jsp:include>

	<div class="container">

		<fieldset style="width: 600px; font-family: Arial; font-size: 14px"> 
		
			<legend style="text-align: center">RANDOM QUOTE</legend>
			
			<div style="text-align: center">"${quoteText}"</div>

			<div style="text-align: right; font-style: italic;"> (c) ${quoteAuthor}</div>
			
		</fieldset>

		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
			<legend style="text-align: center">ALL CATEGORIES</legend>
			<div>
				<ol>
				
					<c:forEach items="${categories}" var="category">
					
						<li><a href=category?id=${category.id}><c:out value="${category.getName()}"/></a></li>
						
					</c:forEach>
		
				</ol>
			</div>
		</fieldset>
		
		<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
			<legend style="text-align: center">TOP 10 CATEGORIES</legend>
				<div>
					<ol>
						
						<c:forEach var="map" items="${top10Categories}">
						
   							<li> ${map[0]} : overall amount of pledges = ${map[1]} </li>
   							
						</c:forEach>
					
					</ol>
				</div>
		</fieldset>
	</div>
<jsp:include page="footer.jsp" />