package ua.com.sas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.model.Category;

public class CategoriesAction implements ModelDriven {

	private Category category;

	@Autowired
	private CategoriesDAO categoriesDAO;

	private List<Category> categories;

	@Override
	public Object getModel() {
		return category;
	}

	public String getAll() throws Exception {
		setCategories(categoriesDAO.getCategories());
		return "success";
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
