<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
	<jsp:param value="Top 10 categories" name="title" />
</jsp:include>

	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<ol>
						<c:forEach var="category" items="${top10Categories}">
   							<li><p> ${category[0]} : overall amount of pledges = ${category[1]} </p></li>
						</c:forEach>
					</ol>
				</div>
			</div>
		</div>
	</div>
	
<jsp:include page="footer.jsp" />