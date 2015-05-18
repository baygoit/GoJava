package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.CategoriesRepository;
import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.view.CategoriesPage;

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
