<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<form action="../login" method="post">
	
	<h1>
		Please log in to continue
	</h1>	
	<p>
		Name: <input type="text" name="name" />
	</p>
	<p>
		Password: <input type="password" name="password" />
	</p>
	<p>
		<input type="submit" value="LogIn" />
	</p>
	
</form>

<jsp:include page="footer.jsp" />