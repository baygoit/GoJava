<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp">
	<jsp:param value="Category: ${category.name}" name="title" />
</jsp:include>

<div class="categories">
	<div class="container">
        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center test-box">
					<h2>${category.name}</h2>
					<ul>
						<c:forEach var="project" items="${projects}">
							<li><a href="project?projectId=${project.id}">${project.name}</a></li>
						</c:forEach>
					</ul>
                </div>
            </div>
        </div>
    </div>  
</div>

<jsp:include page="footer.jsp" />