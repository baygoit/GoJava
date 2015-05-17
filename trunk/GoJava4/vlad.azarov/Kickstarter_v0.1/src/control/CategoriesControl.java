package control;

import java.util.ArrayList;

import view.CategoriesPage;
import model.Category;
import model.CategoriesRepository;

public class CategoriesControl {
    
    CategoriesRepository categoriesRepository;
    CategoriesPage categoriesPage;
    
    public CategoriesControl() {
	categoriesRepository = new CategoriesRepository();
	categoriesPage = new CategoriesPage();
    }

    public ArrayList<Category> getCategories() {
	return categoriesRepository.getCategories();
    }

    public void showCategories() {
	categoriesPage.showCategories(getCategories());
    }

}
