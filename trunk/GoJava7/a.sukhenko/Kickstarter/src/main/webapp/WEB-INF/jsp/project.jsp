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
      <hr>
     
     
    </c:otherwise>
</c:choose>

<h3><a href="question/add?projectId=${project.id}">Ask Question</a></h3>	



<h3><a href="reward?projectId=${project.id}">Help the project [Donate]</a></h3>	


<jsp:include page="footer.jsp" />
