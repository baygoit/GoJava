package belskii.artem.kickstarter.mvc.controller;

import java.util.Map;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.view.CategoryView;

public class CategoryController {
	private CategoryModel model;
	private CategoryView view;
	
	public CategoryController(CategoryModel model, CategoryView view) {
		this.model = model;
		this.view = view;
	}
	
	public void addCategory(String categoryName){
		model.addCategory(categoryName);
	}
	
	public Map<Integer, String> getCategoryList(){
		return model.getCategoryList();
	}
	
	public  Map<Integer, String> printCategoryList(){
		return view.printCategoryList(this.getCategoryList());
	}

}
