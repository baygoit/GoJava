<%@page import="ua.com.goit.gojava.alejnikovi.medsystem.*"%>
<%@page import="ua.com.goit.gojava.alejnikovi.medsystem.dao.SpecializationsDAO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
     <script>
         function sendMessage(buttonID){
        	   //prompt("new value", document.getElementsByName(buttonID).valueOf())
               alert("${message}");
         }
     </script>
</head>
<body>
    <b>Список всех специализаций:</b><br>
    
    <table border="1">
        <form action="CreateNew" method="POST">
	        <%SpecializationsDAO db = new SpecializationsDAO();%>
	        <%pageContext.setAttribute("specs", db.getAll());%>

		    <c:forEach var="spec" items="${specs}">
		        <tr>
		           <td><input type="text" name="${spec.getId()}" value="${spec.getName()}"></td>
		           <td>
		              <button type="submit" name="deleteSpecialization" value="${spec.getId()}">Delete</button>
		              <button type="submit" name="updateSpecialization" value="${spec.getId()}" onclick="sendMessage(this.id)">Update</button>
		           </td>
		        </tr>
		    </c:forEach>  
	        
	    </form>
    </table>
    
    <p>
	    <form action="CreateNew" method="POST">
	        <input name="createSpecialization" type="text">
	        <input type="submit" value="Submit">
	    </form>
    </p>  
    


</body>
</html>