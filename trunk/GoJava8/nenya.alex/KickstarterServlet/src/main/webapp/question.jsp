<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Question</title>
</head>
<body>
	<form action="project" method="POST">
		<input type="text" name="question" /> <input type="submit"
			value="Submit" /> <input type="hidden" name="categoryIndex"
			value="${categoryIndex}" /> <input type="hidden" name="projectIndex"
			value="${projectIndex}" />

	</form>

</body>
</html>