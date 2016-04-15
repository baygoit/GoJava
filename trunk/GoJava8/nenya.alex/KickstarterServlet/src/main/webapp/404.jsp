<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error 404!!!</title>
</head>
<body>
	<b>Error 404!!!</b>
	<c:choose>
		<c:when test="${categoryName != null}">
			<p>
				Attention!!! Category <b>${categoryName}</b> doesn't exist!!!
			</p>
			<br />
		</c:when>
		<c:otherwise>
			<p>
				Attention!!! Project <b>${projectName}</b> doesn't exist!!!
			</p>
			<br />
		</c:otherwise>
	</c:choose>

</body>
</html>