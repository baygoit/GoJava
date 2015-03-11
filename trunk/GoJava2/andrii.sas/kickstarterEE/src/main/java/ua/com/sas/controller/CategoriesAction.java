package ua.com.sas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.model.Category;

public class CategoriesAction implements Action{

	private CategoriesDAO categoriesDAO;

	public CategoriesAction(CategoriesDAO categoriesDAO) {
		this.categoriesDAO = categoriesDAO;
	}
	
	@Override
	public String getJsp(HttpServletRequest req, HttpServletResponse resp) {
		List<Category> categories = categoriesDAO.getCategories();
		req.setAttribute("categories", categories);
		return "categories.jsp";
	}

}
