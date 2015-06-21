package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static view.eViews.*;
import view.ViewStrategy;
import view.iView;
import dao.category.Category;
import dao.category.CategoryService;
import dao.category.DBcategoryServiceImpl;
import dao.category.DefaultCategoryServiceImpl;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.quote.DBquoteService;
import dao.quote.DefaultQuoteServiceImpl;
import dao.quote.Quote;
import dao.quote.QuoteService;

public class MainDao implements iModel {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {

		QuoteService quoteService = null;
		CategoryService categoryService = null;
		if (connected()) {
			quoteService = new DBquoteService();
			categoryService = new DBcategoryServiceImpl();
		} else {
			quoteService = new DefaultQuoteServiceImpl();
			categoryService = new DefaultCategoryServiceImpl();
		}

		Quote quote = quoteService.getRandomQuote();
		iView view = ViewStrategy.getInstance().selectView(CATEGORIES_V);
		request.setAttribute("quote", quote);

		List<Category> categories = null;
		categories = categoryService.getAll();
		request.setAttribute("categories", categories);
		view.forward(request, response);

	}

	boolean connected() {
		boolean connected = false;
		try {
			Connection conn = Pool.getInstance().getConnection();
			conn.close();
			connected = true;
		} catch (KickstarterException | SQLException e) {
		}
		return connected;
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		// TODO Auto-generated method stub
		
	}
}
