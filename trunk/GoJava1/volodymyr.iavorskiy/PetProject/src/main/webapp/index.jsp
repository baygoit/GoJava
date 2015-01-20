<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TITLE</title>
<link rel='StyleSheet' type='text/css' href='css/Styles.css' />
</head>
<body>
	<div id="main">
		<div id="loginForm" align="center">
			<form name="input" action="TestServlet" method="post">
				login<input type="text" name="name" /> <br> password<input type="text"
					name="password" /> <br> <br> <input type="submit" value="Enter" />
			</form>
		</div>

		<div>
			<div align="center">
				<form name="time" action="ShowDate.jsp" method="post">
					<input type="submit" value="Show date" />
				</form>
			</div>
			<br>
			</div>
				<div align="center">
					<form name="reqresp" action="httpReqResp" method="get">
						<input type="submit"
							value="Show http requesr-response parameters." />
					</form>
				</div>


				<div id="menu" align="center">
					<ul>
						<li><a href="">Articles</a></li>
						<li><a href="Files">Learning items</a></li>
						<li><a href="">Event calendar</a></li>
					</ul>
				</div>


				<div align="center">
					<h3>Greetings.</h3>
				</div>

			</div>
			
			<div align="center">
			<h2>Current time is:</h2>
					<%=new java.util.Date()%>
			</div>
</body>
</html>