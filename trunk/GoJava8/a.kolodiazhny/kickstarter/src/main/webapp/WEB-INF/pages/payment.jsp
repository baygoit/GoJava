<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/pages/header.jsp" />
        <div class="container">
            <jsp:include page="navigation.jsp" />
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Payment:</div>
                <div class="panel-body">
                    <form role="form" name="add_invest" method="POST" action="">
                        <div class="form-group">
                            <input type="hidden" name="action" value="paymentAdd"/>
                        	<input type="hidden" name="projectId" value="${project.id}"/>
                            <label for="cardHolder">Card Holder</label>
                            <input class="form-control" name="cardHolder" placeholder="Bob" value="Bob"/>
                            <label for="cardNumber">Card Number</label>
                            <input class="form-control" pattern="[0-9]{12}" name="cardNumber" title="Format: 12 digits" placeholder="123456789011"  value="123456789011"/>
                            <label for="amount">Amount</label>
                            <input class="form-control" name="amount" placeholder="100" value="100" title="Format: 3 digits"/>
                        </div>
                        <div class="form-group">
                            <button type="submit" value="send" class="btn btn-default">Submit</button>
                            <a class="btn btn-default" href='?view=project&id=${project.id}'>Return</a>
                        </div>
                        <label for="awards">Awards:</label>
                        <div id="awards" class="container">
                            <div class="row">
                                <c:forEach var="award" items="${awards}" varStatus="varStatus">
                                    <div class="col-xs-4">
                                        <button type="submit" value="${award.amount}" class="btn btn-default btn-small" name="award">
                                            ${award.amount}$-
                                            ${award.name}
                                        </button>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
<jsp:include page="footer.jsp" />