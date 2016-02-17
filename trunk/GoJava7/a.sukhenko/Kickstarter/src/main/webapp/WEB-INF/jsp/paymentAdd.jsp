<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
    <%@page session="true"%>
<jsp:include page="header.jsp">
	<jsp:param value="Add Question" name="title"/>
</jsp:include>


<h2><spring:message code="lbl.page" text="Add New Payment" /></h2>
<springForm:form method="POST" commandName="payment"
        action="add.do">
        <table>
            <tr>
            	<td>Enter card holder name:</td>
                <td><springForm:input path="cardOwner" /></td>
				<td><springForm:errors path="cardOwner" cssClass="error" /></td>
             </tr>
             <tr>
             	<td>Enter Card Number: </td>
                <td><springForm:input path="cardNumber" /></td>
                <td><springForm:errors path="cardNumber" cssClass="error" /></td>
              </tr>
              <tr>
              	<td>Enter amount: </td>
            	<td><springForm:input path="amount" value="${amount}"/></td>
            	<td><springForm:errors path="amount" cssClass="error" /></td>
            </tr>
           
            <tr>
                <td colspan="3"><input type="submit" value="Donate"></td>
            </tr>
        </table>
  <springForm:hidden path="projectId" value="${projectId}" />
    </springForm:form>









<jsp:include page="footer.jsp" />

