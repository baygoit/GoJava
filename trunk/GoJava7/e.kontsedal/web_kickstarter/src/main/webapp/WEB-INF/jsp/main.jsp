<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
			<blockquote class="blockquote-reverse">
			  <p>${text}</p>
			  <footer><cite title="Source Title">${author}</cite></footer>
			</blockquote>
			<ul class="nav nav-pills">
				<c:forEach items="${categories}" var="category">
					<li role="presentation"><a href="./category?id=${category.getIdCategory()}">${category.getCategoryName()}</a></li>
				</c:forEach>
			</ul>
<jsp:include page="footer.jsp" />