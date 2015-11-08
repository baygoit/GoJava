
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<h2>
	<br>
	<c:out value="user: ${userName}" />
	<br>
	 <input type="button" value="Donate"
		onclick="self.location='donate?project=${detailedProject.ID}&category=${category}';" />
	<input type="button" value="Invest"
		onclick="self.location='invest?project=${detailedProject.ID}&category=${category}';" />
	<input type="button" value="Comment"
		onclick="self.location='Comment?project=${detailedProject.ID}&category=${category}';" />
	<br> <br>

</h2>

