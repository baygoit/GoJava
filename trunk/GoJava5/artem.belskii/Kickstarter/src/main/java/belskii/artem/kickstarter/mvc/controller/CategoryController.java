package belskii.artem.kickstarter.mvc.controller;

import java.util.List;

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
	
	public List<Category> getCategoryList(){
		return model.getCategoryList();
	}
	
	public void printCategoryList(){
		view.printCategoryList();
	}

}
