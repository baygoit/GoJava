<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
	<jsp:param value="Selected category" name="title" />
</jsp:include>

	<c:forEach items="${projects}" var="project">
		<div class="container">
			<div class="row">
				<div class="box">
					<div class="col-lg-12">
						<hr>
							<h2 class="intro-text text-center">Project: 
								<a href="project?id=${project.id}"><strong>${project.name}</strong></a>
							</h2>
						<hr>
						<p><strong>Short description:</strong> ${project.shortDescription}</p>
						<p><strong>Required amount:</strong> ${project.requiredSum} $</p>	
						<p><strong>Collected amount:</strong> ${project.collectedSum} $</p>
						<p><strong>Days left:</strong> ${project.daysLeft}</p>
					</div>
				</div>
		    </div>
	 	</div>
	</c:forEach>
	
<jsp:include page="footer.jsp" />