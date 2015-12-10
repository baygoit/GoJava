<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="header.jsp">
	<jsp:param value="My Title" name="title"/>
</jsp:include>
	<p>
	${quote.text}
	<br />
	<i>${quote.author}</i>
	</p>
	<h1>Categories:</h1>
	<ul>
		<c:forEach var="category" items="${categories}" >
			<li>
				<a href="category?id=${category.id}">${category.name}</a>
			</li>
		</c:forEach>
	</ul>
<jsp:include page="footer.jsp" />
