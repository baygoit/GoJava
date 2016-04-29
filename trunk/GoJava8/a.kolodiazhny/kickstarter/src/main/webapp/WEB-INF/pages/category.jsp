<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="container">
            <%@ include file="navigation.jsp" %>
            <div class="page-header">
                <h2>${title}</h1>
            </div>
            <ol class="breadcrumb">
                <li><a href="?view=categories">All</a></li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-heading">Projects:</div>
                    <table class="table">
                        <tr>
                            <td>Name</td>
                            <td>Short Description</td>
                            <td>Required Budget</td>
                            <td>Gathered Budget</td>
                            <td>Days left</td>
                        </tr>
                        <c:forEach var="project" items="${projects}">
                            <tr>
                                <td><a href="?view=project&id=${project.id}">${project.name}</a></td>
                                <td>${project.description}</td>
                                <td>${project.requiredBudget}</td>
                                <td>${project.gatheredBudget}</td>
                                <td>${project.daysLeft}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
<%@ include file="footer.jsp" %>