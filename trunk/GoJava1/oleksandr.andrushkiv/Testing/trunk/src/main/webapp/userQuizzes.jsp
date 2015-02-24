<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>select the quiz</title>
</head>
<body>

	<h3>Please select the quiz</h3>
	
		<form action="Quizer" method="POST">
			<c:forEach var="entry" items="${userDetailsMap}">
  Профіль: <c:out value="${entry.key.name}" />

				<table>
					<c:forEach items="${entry.value}" var="quiz">
						<tr>
							<td><input type="radio" name="selectedQuiz"
								value="${quiz.id}"> <c:out value="${quiz.name}" /><Br>
							</td>
						</tr>
					</c:forEach>
				</table>
				<br />
			</c:forEach>
			
			<input type="submit" value="Submit" />
		</form>
</body>
</html>