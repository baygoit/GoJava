<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="kickstarter" />
</jsp:include>

<h1>Kickstarter</h1>

	<em>${quote.text}</em> <em>${quote.author}</em>

	<p>Categories:</p>
	<ul>
		<c:forEach var="category" items="${requestScope.categories}">
			<li><a href="category.html?id=${category.categoryId}">${category.name}</a></li>
		</c:forEach>
	</ul>	
	
<jsp:include page="footer.jsp" />