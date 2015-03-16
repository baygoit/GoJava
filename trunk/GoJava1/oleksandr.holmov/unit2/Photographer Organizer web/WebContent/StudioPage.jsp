<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Photo studio data</title>
</head>
<body>
	<form action="<c:url value="/editstud"/>" method="post">
		<input type="hidden" name="studioId" value="${studio.studioId}">
		<table>
			<tr>
				<th><h3>Photo studio form</h3></th>
			</tr>
			<tr>
				<td>Studio name:</td><td><input type="text" name="studname" value="${studio.name}"></td>
			</tr>
			<tr>
				<td>Studio address:</td><td><input type="text" name="studaddress" value="${studio.address}"></td>
			</tr>
			<tr>
				<td>Studio phone:</td><td><input type="text" name="studphone" value="${studio.phone}"></td>
			</tr>
			<tr>
				<td>Studio info:</td><td><input type="text" name="studinfo" value="${studio.info}"></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>	
			<tr>
				<td>Reserve studio:</td><td><input type="submit" name="reservelist" value="Get list"></td>
			</tr>
		</table>

		<table>
                <tr>
                    <th>&nbsp;</th>
                    <th>Date to reserve studio</th>
                    <th>Time to work in studio</th>
                </tr>
                <c:forEach var="i" items="">
                <tr>
                    <td><input type="radio" name="reserveId" value=""></td>
                    <td><c:out value=""/></td>
                    <td><c:out value=""/></td>
                    <td><c:out value=""/></td>
                </tr>
                </c:forEach>
            </table>
                
            <table>
                <tr>
                    <td><input type="submit" value="Add" name="Add"/></td>
                    <td><input type="submit" value="Edit" name="Edit"/></td>
                    <td><input type="submit" value="Delete" name="Delete"/></td>
                </tr>
            </table>
		<hr align="left" width="300" color="red">
		<table>
			<tr>
				<td><input type="submit" name="ok" value="OK"></td>
				<td><input type="submit" name="cancel" value="Cancel"></td>
				<td><input type="reset" name="reset" value="Clear"></td>
			</tr>
		</table>
	</form>
</body>
</html>