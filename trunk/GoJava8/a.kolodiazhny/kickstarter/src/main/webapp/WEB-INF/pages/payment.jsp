<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/pages/header.jsp" />
        <div class="container">
            <jsp:include page="navigation.jsp" />
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <ol class="breadcrumb">
                <li><a  href="<c:url value="/project/${project.id}" />">${project.name}</a></li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-heading">Payment:</div>
                <div class="panel-body">
                    <form:form action="" method="post" commandName="paymentForm">
                        <div class="form-group">
                            <form:input path="projectId" class="form-control" type="hidden" />
                            <label for="cardHolder">Card Holder</label>
                            <form:input path="cardHolder"  class="form-control" placeholder="Bob" value="Bob"/>
                            <label for="cardNumber">Card Number</label>
                            <form:input path="cardNumber" class="form-control"  placeholder="123456789011"  value="123456789011"/>
                            <label for="amount">Amount</label>
                            <form:input path="amount" class="form-control" placeholder="0" value="0"/>
                        </div>
                        <div class="form-group">
                            <button type="submit" value="addPayment" class="btn btn-default">Submit</button>
                        </div>
                        <label for="awards">Awards:</label>
                        <div id="awards" class="container">
                            <div class="row">
                                <c:forEach var="award" items="${awards}" varStatus="varStatus">
                                    <div class="col-xs-4">
                                        <button type="submit" name="awardId" class="btn btn-default btn-small"  value="${award.id}">
                                           ${award.amount}$-${award.name}
                                        </button>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
<jsp:include page="footer.jsp" />