<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp">
	<jsp:param value="Category" name="title" />
</jsp:include>

<div class="categories">
	<div class="container">
        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center test-box">
                	<h1 class="brand-before">
                        <small>Quote of the day</small>
                    </h1>
                    <h3 class="brand-name">${quote.quoteText}</h3>
                    <h2><small>(${quote.author})</small></h2>

					<ul>
						<c:forEach var="category" items="${categories}">
							<li><a href="projects?categoryId=${category.id}">${category.name}</a></li>
						</c:forEach>
					</ul>
	
                </div>
            </div>
        </div>
    </div>  
</div>
<jsp:include page="footer.jsp" />