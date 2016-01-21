<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="header.jsp">
	<jsp:param value="My Title" name="title"/>
</jsp:include>
<p><i>
	${quote.text}
	</i><br />
	<b>${quote.author}</b>
	</p>
	<h1>Categories:</h1>
	<ul>
		<c:forEach var="category" items="${categories}" >
		<nav class="cl-effect-15">
			<li>
				<a href="category?id=${category.categoryId}">${category.categoryName}</a>
			</li>
		</c:forEach>
		</nav>
	</ul>
<jsp:include page="footer.jsp" />
