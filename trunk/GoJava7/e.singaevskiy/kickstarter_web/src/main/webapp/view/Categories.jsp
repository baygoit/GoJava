<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kickstarter</title>
<%@ include file="html/style.html"%>
</head>
<body>
	<div class="root">
		<div class="box">
			<div class="boxCaption basecolor">

				<jsp:include page="Quote.jsp"></jsp:include>

			</div>
			<div class="boxContent">

				|
				<c:forEach var="category" items="${categories}">
					<a href=./category?id=${category.id}> <c:out
							value="${category.id}. ${category.name}" /></a> | 
				</c:forEach>
				<br>
				<br>

			</div>
		</div>
	</div>

</body>
</html>