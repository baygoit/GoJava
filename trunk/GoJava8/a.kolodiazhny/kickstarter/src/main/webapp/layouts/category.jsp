<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="container">
            <%@ include file="navigation.jsp" %>
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Projects:</div>
                    <table class="table">
                        <tr>
                            <td>Name</td>
                            <td>Short Desription</td>
                            <td>Required Budget</td>
                            <td>Gathered Budget</td>
                            <td>Days left</td>
                        </tr>
                        <c:forEach var="project" items="${projects}">
                            <tr>
                                <td><a href="?view=project&id=${project.id}">${project.name}</a></td>
                                <td>${project.shortDesription}</td>
                                <td>${project.requiredBudget}</td>
                                <td>${project.gatherdBudget}</td>
                                <td>${project.daysLeft}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
<%@ include file="footer.jsp" %>