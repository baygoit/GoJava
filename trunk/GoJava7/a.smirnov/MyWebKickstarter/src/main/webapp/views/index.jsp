<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
	<jsp:param value="Main page" name="title" />
</jsp:include>

	<div class="row">
  		<div class="col-md-7">
			<blockquote class="blockquote-reverse">
				<p>${quoteText}</p>
				<p><small>${quoteAuthor}</small></p>
			</blockquote>
		</div>
	</div>
		
<jsp:include page="footer.jsp" />