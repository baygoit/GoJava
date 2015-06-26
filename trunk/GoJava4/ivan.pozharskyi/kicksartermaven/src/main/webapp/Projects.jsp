<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects menu</title>
</head>
<body>
	
	<c:forEach items="${projects}" var="project">
		<h2>
			<a href="/kicksartermaven/project?id=${project.id}"> 
				<c:out value="${project.name}" /><br>
				
			</a>
			
		</h2>
	
	</c:forEach>
	<form action="" method="post">
	
		<c:out value="Input smth" />
		
		<input type="text" name="form1"><br>
		
		<input type="submit" value="button1" >
	</form>

</body>
</html>