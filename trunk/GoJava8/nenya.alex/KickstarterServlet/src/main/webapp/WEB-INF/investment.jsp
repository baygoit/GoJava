<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Investment</title>
</head>
<body>
    <p>
        <a href="projectServlet?categoryName=${categoryName}&projectName=${projectName}"> Back </a>
    </p>
	<form action="investmentServlet" method="POST">
	<p><input type="radio" name="amount" value="0" checked/>Any amount </p>
		<c:forEach var="reward" items="${rewards}" varStatus="varStatus">
			<p><input type="radio" name="amount" value="${reward.amount}">${reward.name} - ${reward.description}</p>
		</c:forEach>
	<hr/>
    <p><b>Enter amount of investition</b></p>
        <input type="text" name="investition" /> <input type="hidden"
            name="categoryName" value="${categoryName}" /> <input type="hidden"
            name="projectName" value="${projectName}" /> <input type="submit"
            value="Submit" />
    </form>
    
</body>
</html>