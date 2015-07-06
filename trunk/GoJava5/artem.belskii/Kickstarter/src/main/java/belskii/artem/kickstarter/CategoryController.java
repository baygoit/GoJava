package belskii.artem.kickstarter;

import java.util.ArrayList;

public class CategoryController {

	private Category model;
	private CategoryView view;

	public CategoryController(Category model, CategoryView view) {
		this.model = model;
		this.view = view;
	}
	
	public void addCategory(String categoriName){
		model.addCategory(categoriName);
	}
	
	public ArrayList<String> getCategoryList(){
		return model.getCategoryList();
	}

	public void updateView() {
		view.printCategoryList(this.getCategoryList());

	}

}
