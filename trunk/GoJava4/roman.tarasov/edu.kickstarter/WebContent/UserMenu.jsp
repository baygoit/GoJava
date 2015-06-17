
<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<h2 class="for-screenreader" id="user-navigation">User menu</h2>
<ul class="user-menu js-user-menu">
<li class="logged-out-link"><a href="Login.jsp">Log in</a></li>
</ul>
	<h2>
		<c:out value="user : ${userName}" />
	</h2>

