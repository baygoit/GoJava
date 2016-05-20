<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />
        <div class="container">
            <jsp:include page="navigation.jsp" />
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <div class="container-fluid">
            	<div class="row-fluid">
            		<div class="span12">
            			<fieldset>
            			<legend>Payment details:</legend>
            		        <table class="table table-striped">
            				    <tr>
            				        <td>Project ID</td>
                 					<td>Card Number</td>
                 					<td>Amount</td>
            					</tr>
            					    <tr>
            				    	<td>${paymentForm.projectId}</td>
            				    	<td>${paymentForm.cardNumber}</td>
            				    	<td>${paymentForm.amount}</td>
            				    </tr>
                			</table>
            			</fieldset>
            		</div>
            	</div>
            </div>
            <jsp:include page="redirectTimer.jsp" />
        </div>
<jsp:include page="footer.jsp" />
