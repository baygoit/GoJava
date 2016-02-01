<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<form action="/j_spring_security_check" method="post">

	<h1>Please log in to continue</h1>
	<p>
		Name: <input type="text" name="j_username" />
	</p>
	<p>
		Password: <input type="password" name="j_password" />
	</p>
	<p>
		remember me : <input type="checkbox"
			name="_spring_security_remember_me" />
	</p>
	<p>
		<input type="submit" value="LogIn" />
	</p>

</form>

<jsp:include page="footer.jsp" />