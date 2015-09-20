package goit.iavorskyi.ui;

import goit.iavorskyi.db.ArticleDao;
import goit.iavorskyi.domain.Article;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticleCrudServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Article article = new Article();
			ArticleDao articleDao = new ArticleDao();
			article.setAuthor(request.getParameter("author"));
			article.setHeader(request.getParameter("header"));
			article.setText(request.getParameter("text"));
			articleDao.saveArticle(article);
			response.setContentType("text/html;charset=UTF-8");
			response.sendRedirect("/JavaHub/articles.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=UTF-8");
			response.sendRedirect("");
		}

	}

}
