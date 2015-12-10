<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message</title>
<%@ include file="html/style.html"%>
</head>
<body>
	<div class="root">
		<div class="box">
		
			<jsp:include page="Error.jsp"/>
		
			<div class="boxCaption basecolor">
				<span>Enter your message</span>
			</div>
			<div class="boxContent">
				<form action="project" method="post" id="submitForm">
					<input type="hidden" name="projectId" value=${param['projectId']}>
					<input type="hidden" name="operation" value="message">
					<table>
						<tr>
							<td>Username:</td>
							<td><input type="text" name="user" value="User"></td>
						</tr>
						<tr>
							<td>Message:</td>
							<td><textarea rows="5" name="message">Text</textarea></td>
						</tr>
					</table>
				</form>
				<div class="controls basecolor">
					<jsp:include page="html/Submit.html" />
					<jsp:include page="html/Back.html" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>