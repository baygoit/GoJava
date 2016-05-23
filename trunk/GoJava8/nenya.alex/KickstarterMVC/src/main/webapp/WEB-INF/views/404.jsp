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
		<c:when test="${categoryTestId == -1}">
			<p>
				Attention!!! Category with id <b>${categoryId}</b> doesn't exist!!!
			</p>
			<br />
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${projectTestId == -1}">
					<p>
						Attention!!! Project with id <b>${projectId}</b> doesn't exist!!!
					</p>
					<br />
				</c:when>
				<c:otherwise>
					<p>
						Attention!!! Reward with id <b>${rewardId}</b> doesn't exist!!!
					</p>
					<br />
				</c:otherwise>
			</c:choose>
			
		</c:otherwise>
	</c:choose>

</body>
</html>