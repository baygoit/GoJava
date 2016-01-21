<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="header.jsp">
	<jsp:param value="Projects" name="title"/>
</jsp:include>
<a href="category?id=${project.category.categoryId}">${project.category.categoryName}</a> > ${project.projectName}
<c:choose>
    <c:when test="${notfound == true}">
        Sorry, project not found. 
        <br />
    </c:when>    
    <c:otherwise>
    
        <h2>Project: "${project.projectName}"</h2><hr> <br>
	
	<p>Description: ${project.projectDescription} </p> <hr> <br>
	
	<p> History: ${project.projectHistory} </p> <hr> <br>
	<p><a href="${project.demoLink}">${project.demoLink}</a></p>
	<p> Money needed: ${project.moneyNeeded} </p> 
	<p>Time: ${endtime} </p>
	
        <br />
 <!--  there was stuff here -->
     
 
     <hr>
   	<c:forEach var="question" items="${questions}" >
			 Q: ${question.question} <br>
			 A: ${question.answer} <br><br>
			
		</c:forEach>
      
     
     
    </c:otherwise>
</c:choose>

<h2><spring:message code="lbl.page" text="Add New Question" /></h2>
<form:form method="post" modelAttribute="question">
        <%-- <form:errors path="*" cssClass="error" /> --%>
        <table>
            <tr>
            <form:textarea path="address" rows="5" cols="30" />
                <td><spring:message code="lbl.question" text="First Name" /></td>
                <td><form:textarea path="question" rows="5" cols="60" /></td>
                <td><form:errors path="question" cssClass="error" /></td>
            </tr>
     
            <tr>
                <td colspan="3"><input type="submit" value="Ask question"/></td>
            </tr>
        </table>
    </form:form>

<form action="question" method="post">
	<br>Ask your question:
	<br><textarea name="question" rows="5" cols="60"></textarea>
	<br> <input type="hidden" name="id" value="${project.id}" />
	<input type="submit" value="Submit" />
</form>

<h3><a href="reward?id=${project.id}">Help the project [Donate]</a></h3>	


<jsp:include page="footer.jsp" />
