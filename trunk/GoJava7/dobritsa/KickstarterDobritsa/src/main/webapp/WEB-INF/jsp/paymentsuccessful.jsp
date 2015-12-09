<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="PaymentSuccessful" />
</jsp:include>

<h3><a href="categories">Kickstarter</a></h3>
<h3><a href="projects?id=${category.id}">${category.name}</a></h3>
<h1><a href="project?id=${project.id}">${project.name}</a></h1>

<h3>Thanks for your donation!</h3>

<br>Amount of your donation is $${amount}<br>

<br>It was collected before: ${pledgedOld}<br>
<br>Now collected: ${pledgedNew}<br>


<jsp:include page="footer.jsp" />