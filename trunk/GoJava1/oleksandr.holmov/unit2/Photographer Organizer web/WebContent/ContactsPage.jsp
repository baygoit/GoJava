<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="enableButtons.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts data</title>
</head>
<body>
	<form action="<c:url value="/contacts"/>" method="post">
		<h3>List of contacts</h3>
		<table>
			<tr>
				<td> list of contacts for:
					<select name="typecontact">
						<option value="cust">customer</option>
						<option value="stud">studio</option>
					</select> 
				</td>
				<td><input type="submit" name="getlist" value="Get list"></td>
			</tr>
		</table>
		<br>
		
		<table>
			<tr>
				<th> </th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Info</th>
			</tr>
			<c:if test="${form.type eq 'C'}">
				<c:forEach var="i" items="${form.list}">
				<tr>
					<td><input type="radio" name="cont_id" value="${i.customerId}"></td>
					<td><c:out value="${i.name}"/></td>
					<td><c:out value="${i.address}"/></td>
					<td><c:out value="${i.phone}"/></td>
					<td><c:out value="${i.additionalInfo}"/></td>
				</tr>
				</c:forEach>				
			</c:if>
			<c:if test="${form.type eq 'S'}">
				<c:forEach var="i" items="${form.list}">
				<tr>
					<td><input type="radio" name="cont_id" value="${i.studioId}"></td>
					<td><c:out value="${i.name}"/></td>
					<td><c:out value="${i.address}"/></td>
					<td><c:out value="${i.phone}"/></td>
					<td><c:out value="${i.additionalInfo}"/></td>
				</tr>
				</c:forEach>			
			</c:if>
		</table>
		
		<table>
			<tr>
				<td><input type="submit" name="add" value="Add"></td>
				<td><input type="submit" name="edit" value="Edit"></td>
				<td><input type="submit" name="delete" value="Delete"></td>
			</tr>
		</table>
	</form>
</body>
</html>