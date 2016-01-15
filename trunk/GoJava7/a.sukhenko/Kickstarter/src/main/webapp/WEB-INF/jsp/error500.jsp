<jsp:include page="header.jsp" />
<%@ page isErrorPage="true"%>
<h3> Oops. Server error has happened. </h3>
<% exception.printStackTrace(response.getWriter()); %>
<jsp:include page="footer.jsp" />