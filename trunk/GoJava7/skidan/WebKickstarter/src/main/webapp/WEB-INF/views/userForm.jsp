<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>User Form</title>
</head>
<body>


<div align="center">
        <h2>Please fill in forms below</h2>
        <table border="0" width="90%">
        <form:form  action="/WebKickstarter/user/accept" method = "post" commandName="userVO">
                 <tr><td><label for="name">Name:</label></td></tr>
               <tr>
                    <td><form:input class="form-control" id="name" placeholder="Enter name" path="name" /></td>
                    <td><form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr><td><label for="pwd">Password:</label></td></tr>
                <tr>
                    <td><form:input type="password" class="form-control" id="pwd" placeholder="Enter password" path="password" /></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
                
			      	<td><label>ProjectOwner</label><input type="radio" class="checkbox" value="3" name="userRoleId"/>
			      	<label>User</label><input type="radio" class="checkbox" value="2" name="userRoleId"/></td>
                <tr>
                    <td></td>
                    <td><input type="submit" class="btn btn-danger btn-lg" value="Submit"/></td>
                    <td></td>
                </tr>
        </form:form>
        </table>
         
    </div>
</body>
</html>
