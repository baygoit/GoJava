<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="edu.kickstarter.entity.Category"
	import="edu.kickstarter.DAO.Dao"
	import="edu.kickstarter.database.KickstarterException"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kickstarter.edu</title>
</head>
<body>
	<%
		StringBuffer html = new StringBuffer();
		String quote;
		List<Category> categories;
		try {
			quote = Dao.getQuoteService().getRandomQuote().getQuote();
			categories = Dao.getCategoryService().getAll();
			out.println(quote);
			
			html.append("<nav>");
			html.append("<ul class='top-menu'>");
			for (Category currentCategory : categories) {
		html.append("<li><a href='Projects");
		html.append("'/>");
		html.append(currentCategory.getName());
		html.append("</a></li>");
			}
			html.append("</ul>");
			html.append("</nav>");
			out.println(html.toString());
		} catch (KickstarterException e) {
			
		}

	%>
</body>
</html>