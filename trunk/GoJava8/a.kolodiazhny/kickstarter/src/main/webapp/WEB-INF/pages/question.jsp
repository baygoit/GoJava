<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />
        <div class="container">
            <jsp:include page="navigation.jsp" />
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Add question:</div>
                <div class="panel-body">
                    <form:form action="" method="post" commandName="questionForm">
                        <div class="form-group">
                            <label for="text">Please fill your question:</label>
                            <form:input path="projectId" class="form-control" type="hidden" />
                            <form:textarea path="text" rows="5" cols="30" class="form-control" />
                         </div>
                        <button type="submit" value="addQuestion" class="btn btn-default">Submit</button>
                        <a class="btn btn-default" href="<c:url value="/project/${project.id}" />">Return to ${project.name}</a>
                    </form:form>
                </div>
            </div>
        </div>
<jsp:include page="footer.jsp" />