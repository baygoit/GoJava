<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Kickstarter payment</title>
</head>
<body>
	<form action="payment" method="post">
		Name: <input type="text" name="name"><br/>
		Card number: <input type="text" name="cardNumber"><br/>
		$$$: <input type="text" name="amount"><br/>
		<input type="hidden" name="projectId" value="${projectId}">
        <input type="hidden" name="categoryId" value="${categoryId}">
		<input type="submit" value="Donate">
		<span class="error">${message}</span>
	</form>
	<a href="project?project=${projectId}&category=${categoryId}">Go back</a></br>
</body>
</html>
