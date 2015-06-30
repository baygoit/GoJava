
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<h2>
	<c:out value="${userName}" />

	<input type="button" value="Donate" onclick="self.location='donate';" />
	<input type="button" value="Invest" onclick="self.location='invest';" />
	<input type="button" value="Comment"
		onclick="self.location='Comment?project=${detailedProject.ID}&category=${category}';" />
	<br> <br>

</h2>

