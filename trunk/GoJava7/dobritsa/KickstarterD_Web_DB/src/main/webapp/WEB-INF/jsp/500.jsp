<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Category" />
</jsp:include>

<h1>what have you done?</h1>

<h1>status</h1>
<h3>${status}</h3>

<h1>reason</h1>
<h3>${reason}</h3>


<jsp:include page="footer.jsp" />