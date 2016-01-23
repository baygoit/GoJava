<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<jsp:include page="header.jsp">
	<jsp:param value="Add Question" name="title"/>
</jsp:include>


<h2><spring:message code="lbl.page" text="Add New Question" /></h2>
<springForm:form method="POST" commandName="question"
        action="add.do">
        <table>
            <tr>
                <td>Question:</td>
                <td><springForm:textarea path="question" rows="5" cols="60" /></td>
                <td><springForm:errors path="question" cssClass="error" />
                 <springForm:hidden path="projectId" value="${projectId}" /> </td>
              
            </tr>
           
            <tr>
                <td colspan="3"><input type="submit" value="Add question"></td>
            </tr>
        </table>
 
    </springForm:form>









<jsp:include page="footer.jsp" />

