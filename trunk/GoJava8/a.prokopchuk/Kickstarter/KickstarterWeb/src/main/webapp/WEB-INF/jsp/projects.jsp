<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp">
	<jsp:param value="Category: ${category.name}" name="title" />
</jsp:include>

<div class="categories">
	<div class="container">
        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                	<ul class="breadcrumb">
                		<li><a href="/">Home</a></li>
						<li><a href="categories">Categories</a></li>
					</ul>
					<h2>Selected category: ${category.name}</h2>
					<div class="row">
						<div class="project-list">
							<c:forEach var="project" items="${projects}" varStatus="status">
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="project-list-item">
										<a href="project?projectId=${project.id}">
											<span class="project-list-item-name">${project.name}</span>
											<span>Description: ${project.description}</span>
											<span>Required budget: ${project.requiredBudget}</span>
											<span>Gathered budget: ${project.gatheredBudget}</span>
											<span>Days left: ${project.finalDate}</span>
										</a>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
                </div>
            </div>
        </div>
    </div>  
</div>

<jsp:include page="footer.jsp" />