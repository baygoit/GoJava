<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
     
         Bonuses:
        	<ul>
   	<c:forEach var="pBonus" items="${paymentBonuses}" >
   
			<li>
			 ${pBonus.amount}  - ${pBonus.bonus}
			</li>
			
		</c:forEach>
     </ul>   
     <hr>
   	<c:forEach var="question" items="${questions}" >
			 Q: ${question.question} <br>
			 A: ${question.answer} <br><br>
			
		</c:forEach>
      
     
     
    </c:otherwise>
</c:choose>
	
	
<jsp:include page="footer.jsp" />
