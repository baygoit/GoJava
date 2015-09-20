package ua.com.goit.gojava2.vova.kickstarter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesInt;
import ua.com.goit.gojava2.vova.kickstarter.model.Category;

public class CategoriesAction implements Action {

	private CategoriesInt dao;

	public CategoriesAction(CategoriesInt categoriesDAO) {
		dao = categoriesDAO;
	}

	@Override
	public String doIt(HttpServletRequest req, HttpServletResponse resp) {
		List<Category> categories = dao.getCategories();
		req.setAttribute("categories", categories);
		return "categories.jsp";
	}

}
