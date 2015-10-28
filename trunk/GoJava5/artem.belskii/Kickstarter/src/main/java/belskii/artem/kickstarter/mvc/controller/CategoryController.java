package belskii.artem.kickstarter.mvc.controller;

import java.util.Map;
import belskii.artem.kickstarter.mvc.model.CategoryModel;

public class CategoryController {
	private CategoryModel model;
	
	public CategoryController(CategoryModel model) {
		this.model = model;
	}
	
	public void addCategory(String categoryName){
		model.addCategory(categoryName);
	}
	
	public Map<Integer, String> getCategoryList(){
		return model.getCategoryList();
	}
}
