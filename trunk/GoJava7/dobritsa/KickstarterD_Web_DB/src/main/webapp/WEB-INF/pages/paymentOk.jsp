<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="PaymentOk" />
</jsp:include>

<c:if test="${pageContext.request.userPrincipal.name == null}">
	<h3><a href="login">Login</a></h3>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	<h3>Welcome : ${pageContext.request.userPrincipal.name} |
		<a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h3>
</c:if>

<h3><a href="index">Kickstarter</a>
/
<a href="category?categoryId=${category.categoryId}">${category.name}</a></h3>
<h1><a href="project?projectId=${project.projectId}">${project.name}</a></h1>

<h3>Thanks for your donation!</h3>

<br>$${amount} will be transferred to the project<br>

<jsp:include page="footer.jsp" />