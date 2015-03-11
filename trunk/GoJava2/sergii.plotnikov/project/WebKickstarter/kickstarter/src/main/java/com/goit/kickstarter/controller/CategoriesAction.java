package com.goit.kickstarter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goit.kickstarter.dao.CategoryDAO;
import com.goit.kickstarter.model.Category;

public class CategoriesAction implements Action {
	
	private CategoryDAO dao;
	
	public CategoriesAction(CategoryDAO dao){
		this.dao=dao;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) {
		List<Category> categories = dao.getCategories();
		req.setAttribute("categories", categories);
		return "categories.jsp";
	}

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
