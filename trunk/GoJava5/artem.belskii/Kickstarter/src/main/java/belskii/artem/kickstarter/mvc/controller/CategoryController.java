package belskii.artem.kickstarter.mvc.controller;

import java.util.ArrayList;

import belskii.artem.kickstarter.dao.category.Category;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.view.CategoryView;

public class CategoryController {
	private CategoryModel model;
	private CategoryView view;
	
	public CategoryController(CategoryModel model, CategoryView view) {
		this.model = model;
		this.view = view;
	}
	
	public void addCategory(Category categoriName){
		model.addCategory(categoriName);
	}
	
	public ArrayList<Category> getCategoryList(){
		return model.getCategoryList();
	}
	
	public  ArrayList<Category> printCategoryList(){
		return view.printCategoryList(this.getCategoryList());
	}

}
