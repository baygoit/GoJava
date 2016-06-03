<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="header.jsp">
	<jsp:param value="Category: ${category.name}" name="title" />
</jsp:include>

<div class="categories">
	<div class="container">
        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                	<ul class="breadcrumb">
                		<li><a href="<c:url value="/" />"><spring:message code="category.homeBreadcrumb" /></a></li>
						<li><a href="<c:url value="/categories" />"><spring:message code="category.categoriesBreadcrumb" /></a></li>
					</ul>
					<h2>Selected category: ${category.name}</h2>
					<div class="row">
						<div class="project-list">
							<c:forEach var="project" items="${projects}" varStatus="status">
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="project-list-item">
										<a href="<c:url value="/project/${project.id}" />">
											<span class="project-list-item-name">${project.name}</span>
											<span><spring:message code="category.description" />: ${project.description}</span>
											<span><spring:message code="category.requiredBudget" />: ${project.requiredBudget}</span>
											<span><spring:message code="category.gatheredBudget" />: ${project.gatheredBudget}</span>
											<span><spring:message code="category.daysLeft" />: ${project.finalDate}</span>
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