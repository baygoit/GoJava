<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Kickstarter" />
</jsp:include>

<c:if test="${pageContext.request.userPrincipal.name == null}">
	<h3><a href="login">Login</a></h3>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	<h3>Welcome : ${pageContext.request.userPrincipal.name} |
		<a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h3>
</c:if>

<h1>Kickstarter</h1>

	<em>${quote.text}</em> <em>${quote.author}</em>

	<p>Categories:</p>
	<ul>
		<c:forEach var="category" items="${requestScope.categories}">
			<li><a href="category?categoryId=${category.categoryId}">${category.name}</a></li>
		</c:forEach>
	</ul>	
	
<jsp:include page="footer.jsp" />