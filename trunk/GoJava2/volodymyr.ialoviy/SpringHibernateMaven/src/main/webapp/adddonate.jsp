<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donation registration form</title>
<style>.error {color: #ff0000;}</style>
</head>

<body>
	<h2>Donation form</h2>
	 <form method="POST" >
		<table>
		    <tr>
		        <td><b>Your name: </b></td>
		        <td><input type = "text" name = "name" /></td>
		    </tr>
		    <tr>
		        <td><b>Your email: </b></td>
		        <td><input type="text" name = "mail" /></td>
		    </tr>
		    <tr>
		        <td><b>Your credit card: </b></td>
		        <td><input type="text" name = "card" /></td>
		    </tr>
		    <tr>
		        <td><b>Your amount: </b></td>
		        <td><input type="text" name = "amount" value="${amount}" /></td>
		    </tr>
			<tr>
				<td colspan="3"><input type="submit" value="donete" /></td>
			</tr>
		</table>
	</form>
	<p>Go back to <a href="${ctx}/projects/${idProject}?show">project # ${idProject}</a></p>
</body>
</html>