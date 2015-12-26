<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Kickstarter" />
</jsp:include>

<h1>Kickstarter</h1>

	<em>${quote.text}</em> <em>${quote.author}</em>

	<p>Categories:</p>
	<ul>
		<c:forEach var="category" items="${requestScope.categories}">
			<li><a href="projects?id=${category.categoryId}">${category.name}</a></li>
		</c:forEach>
	</ul>		
	
	<p>Top categories by pledged:</p>
	<ul>
		<c:forEach var="categoryIn10" items="${requestScope.top10Categories}">
			<li>$${categoryIn10.money} - <a href="projects?id=${categoryIn10.categoryId}">${categoryIn10.name}</a></li>			
		</c:forEach>
	</ul>	

<jsp:include page="footer.jsp" />