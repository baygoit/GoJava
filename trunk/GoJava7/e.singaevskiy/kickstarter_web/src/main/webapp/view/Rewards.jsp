<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${project.name}</title>
<%@ include file="html/style.html"%>
</head>
<body>
	<div class="root">
		<div class="box">
			<div class="boxCaption basecolor">Select your reward</div>
			<div class="boxContent">
				<table>
					<c:forEach var="reward" items="${rewards}">

						<tr>
							<td><a
								href=./payment?project=${project.id}&reward=${reward.id}&amount=${reward.getPledgeSum()}>Pay
									${reward.getPledgeSum()}</a></td>

							<td>${reward.getDescription()}</td>
						</tr>

					</c:forEach>


					<tr>
						<td><a href=./payment?project=${project.id}>Pay any amount you
								like</a></td>
						<td></td>
					</tr>


				</table>


				<div class="controls basecolor"><jsp:include page="html/Back.html"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>