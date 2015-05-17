package control;

import view.CategoryPage;
import model.CategoryRepository;

public class CategoryControl {
	
	private CategoryRepository categoryRepository;
	private CategoryPage categoryPage;
	
	public CategoryControl(){
		categoryRepository = new CategoryRepository();
	}
	
	public void callToShowCategories(){
		categoryPage.showCategories();
	}
	
}
