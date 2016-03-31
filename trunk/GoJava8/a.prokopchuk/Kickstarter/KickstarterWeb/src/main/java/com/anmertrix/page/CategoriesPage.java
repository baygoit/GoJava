package com.anmertrix.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Quote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriesPage extends Page {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
 
        PrintWriter pw = resp.getWriter();
        QuoteDao quoteDao = page.getQuoteDao();
        CategoryDao categoryDao = page.getCategoryDao();
        Quote quote = quoteDao.getRandomQuote();
        pw.println("<H2>" + quote.getQuoteText() + " (" + quote.getAuthor() + ")" + "</H2>");
        List<Category> categories = categoryDao.getCategories();
        pw.println("<ul>");
        for (Category category: categories) {
			pw.println("<li><a href=\"projects?categoryId=" + category.getId() + "\">" + category.getName() + "</a></li>");
		}
		pw.println("</ul>");
    }
	

}
