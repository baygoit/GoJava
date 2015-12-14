<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="PaymentFailed" />
</jsp:include>

<h3><a href="categories">Kickstarter</a>
/
<a href="projects?id=${category.id}">${category.name}</a></h3>
<h1><a href="project?id=${project.id}">${project.name}</a></h1>



<jsp:include page="footer.jsp" />