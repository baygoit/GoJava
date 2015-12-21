<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="header.jsp">
	<jsp:param value="Projects" name="title"/>
</jsp:include>
<c:choose>
    <c:when test="${notfound == true}">
        Sorry, project not found. 
        <br />
    </c:when>    
    <c:otherwise>
    
        <h2>Project "${project.projectName}"</h2><hr> <br>
	
	<p> ${project.projectDescription} </p> <hr> <br>
	
	<p> ${project.projectHistory} </p> <hr> <br>
	
	<p> Money needed: ${project.moneyNeeded} </p> 
        <br />
        
        
    </c:otherwise>
</c:choose>
	
	
<jsp:include page="footer.jsp" />
