<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/pages/header.jsp" />
        <div class="container">
            <jsp:include page="/WEB-INF/pages/navigation.jsp" />
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Add question:</div>
                <div class="panel-body">
                    <form role="form" name="add_question" method="POST" action="">
                        <div class="form-group">
                            <input type="hidden" name="action" value="questionAdd"/>
                        	<input type="hidden" name="projectId" value="${project.id}"/>
                            <label for="question">Please fill your question:</label>
                            <textarea rows="5" type="question" class="form-control" name="question"></textarea>
                        </div>
                        <button type="submit" value="send" class="btn btn-default">Submit</button>
                        <a class="btn btn-default" href="?view=project&id=${project.id}">Return</a>
                    </form>
                </div>
            </div>
            <h3></h3>
        </div>
<jsp:include page="footer.jsp" />