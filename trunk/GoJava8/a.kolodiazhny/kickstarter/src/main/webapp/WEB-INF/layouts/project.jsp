<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="container">
            <%@ include file="navigation.jsp" %>
            <div class="page-header">
              <h2>${title}</h1>
            </div>
             <ol class="breadcrumb">
                <li><a href="?view=category&id=${category.id}">${category.name}</a></li>
             </ol>
            <div class="panel panel-default">
                <div class="panel-heading">Project:</div>
                    <table class="table">
                         <tr>
                          <td>Name:</td>
                          <td>${project.name}</td>
                        </tr>
                        <tr>
                           <td>Description:</td>
                           <td>${project.desription}</td>
                        </tr>
                         <tr>
                           <td>Required:</td>
                           <td>${project.requiredBudget}</td>
                         </tr>
                         <tr>
                            <td>Gathered:</td>
                            <td>
                                ${project.gatheredBudget}
                                <a class="btn btn-default btn-small" href="?view=invest&id=${project.id}" role="button">Invest</a>
                            </td>
                        </tr>
                        <tr>
                            <td>Days Left:</td>
                            <td>${project.daysLeft}</td>
                        </tr>
                        <tr>
                            <td>Video:</td>
                            <td>${project.videoLink}</td>
                        </tr>
                        <tr>
                            <td>History:</td>
                            <td>${project.history}</td>
                        </tr>
                        <tr>
                            <td>Questions:</td>
                            <td>
                                <table class="table">
                                    <c:forEach var="question" items="${questions}" varStatus="varStatus">
                                        <tr><td>${varStatus.count}. ${question.text}</td></tr>
                                    </c:forEach>
                                </table>
                                <a class="btn btn-default btn-small" href="?view=question&id=${project.id}" role="button">Add Question</a>
                            <td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
<%@ include file="footer.jsp" %>