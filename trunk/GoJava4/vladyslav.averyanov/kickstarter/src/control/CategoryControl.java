package control;

import view.CategoryPage;
import model.CategoryRepository;

public class CategoryControl {
	
	CategoryRepository categoryRepository;
	CategoryPage categoryPage;
	
	CategoryControl(){
		categoryRepository = new CategoryRepository();
	}
	
	
	public void callToShowCategories(){
		categoryPage.showCategories();
	}
	
}
