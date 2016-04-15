<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Page not found" scope="request"/>
<jsp:include page="header.jsp"/>
		<h1>Error: 404</h1>
		<h2>Not Found</h2>
		<hr/>
		<br/>
		${requestScope['javax.servlet.error.message']}
<jsp:include page="footer.jsp"/>
