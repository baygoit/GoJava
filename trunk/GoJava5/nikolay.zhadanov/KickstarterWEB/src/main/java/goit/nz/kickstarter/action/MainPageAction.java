package goit.nz.kickstarter.action;

import goit.nz.kickstarter.dao.CategoryDAO;
import goit.nz.kickstarter.dao.QuoteDAO;
import goit.nz.kickstarter.model.MainPageModel;

import javax.servlet.http.HttpServletRequest;

public class MainPageAction implements Action {
	private MainPageModel model;
	private QuoteDAO quoteDAO;
	private CategoryDAO categoryDAO;
	private final String VIEW = "main";

	public void setQuoteDAO(QuoteDAO quoteDAO) {
		this.quoteDAO = quoteDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public String execute(HttpServletRequest request) {
		model = new MainPageModel(quoteDAO, categoryDAO);
		model.update();
		request.setAttribute("model", model);
		return VIEW;
	}

}
