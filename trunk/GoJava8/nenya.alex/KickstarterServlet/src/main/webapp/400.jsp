<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error 400!!!</title>
</head>
<body>
	<b>Error 400!!!</b>
	<c:choose>
		<c:when test="${TestId == -1}">
			<p>
				Attention!!! Id <b>${Id}</b> is incorrect!!!
			</p>
			<br />
		</c:when>
		<c:otherwise>
				<c:choose>
					<c:when test="${investment == '-1'}">
						<p>Attention!!! Investment is empty!!!</p>
						<br />
					</c:when>
					<c:otherwise>
							<c:choose>
								<c:when test="${question == ''}">
									<p>Attention!!! Question is empty!!!</p>
									<br />
								</c:when>
								<c:otherwise>
									<p>
										Attention!!! Question <b>${question}</b> already exists!!!
									</p>
									<br />
								</c:otherwise>
							</c:choose>
						<br />
					</c:otherwise>
				</c:choose>
			<br />
		</c:otherwise>
	</c:choose>

</body>
</html>