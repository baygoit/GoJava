<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="container">
            <%@ include file="navigation.jsp" %>
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Add question:</div>
                <div class="panel-body">
                    <form role="form" name='add_invest' method='POST' action=''>
                        <div class="form-group">
                            <input type='hidden' name='action' value='addInvest'/>
                        	<input type='hidden' name='projectId' value='${project.id}'/>
                            <label for="question">Please fill your question:</label>
                            <textarea rows="5" type="question" class="form-control" name="question"></textarea>
                        </div>
                        <button type="submit" value="send" class="btn btn-default">Submit</button>
                        <a class="btn btn-default" href='?view=project&id=${project.id}'>Return</a>
                    </form>
                </div>
            </div>
            <h3></h3>
        </div>
<%@ include file="footer.jsp" %>