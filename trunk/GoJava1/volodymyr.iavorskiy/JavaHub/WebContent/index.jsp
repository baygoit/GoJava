<%@page import="goit.iavorskyi.domain.Rating"%>
<%@page import="goit.iavorskyi.ui.UIFacade"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JavaHub</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="validator.js"></script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1>Header</h1>
		</div>
		<div class="body">
			<a href="articles.jsp">
				<div class="articles">
					<h1>Articles</h1>
					list of articles <br> add new article <br> find article <br> rating of usefullness
				</div>
			</a> <a href="sandBox.jsp">
				<div class="sandBox">
					<h1>Sand Box</h1>
					list of code examples <br> add some code <br> find some
					code <br> comment code <br> review code
					<div class=""></div>
				</div>
			</a> <a href="books.jsp">
				<div class="videoLessons">
					<h1>Video Lessons</h1>
					list of books <br> add new book <br> find book <br> rating of usefullness <br> comments
					<div class=""></div>
				</div>
			</a> <a href="videoLessons.jsp">
				<div class="books">
					<h1>Books</h1>
					list of lessons <br> add new lesson <br> find lesson <br> rating of usefullness <br> comments
					<div class=""></div>
				</div>
			</a>
		</div>
		<div class="footer">
			<h1>Footer</h1>
			<div class=""> footer</div>
		</div>
	</div>
</body>
</html>