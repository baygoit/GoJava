<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Payment" />
</jsp:include>

<h3><a href="index">Kickstarter</a>
/
<a href="category?categoryId=${category.categoryId}">${category.name}</a></h3>
<h1><a href="project?projectId=${project.projectId}">${project.name}</a></h1>

<h3>Amount of your donation is $${amount}</h3>

<form action="paymentCheck" method="post">

<font color=red><c:if test="${not empty message}">${message}</c:if></font >
<br><br>Enter your name: <input type="text" name="name" value="" size=20 maxlength=20><br>
<br>Enter your card's number: <input type="text" name="card" value="" size=20 maxlength=16><br>
<input type="hidden" name="projectId" value="${project.projectId}"/>
<input type="hidden" name="amount" value="${amount}"/>
<br><input type="submit" value="Submit">
</form>

<jsp:include page="footer.jsp" />