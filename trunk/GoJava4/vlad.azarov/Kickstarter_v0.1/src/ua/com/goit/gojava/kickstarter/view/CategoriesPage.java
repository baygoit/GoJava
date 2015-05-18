package ua.com.goit.gojava.kickstarter.view;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;

public class CategoriesPage {
    
    public void showCategories(ArrayList<Category> categories) {
	System.out.println("Select category: ");
	for (int index = 0; index < categories.size(); index++) {
	    System.out.println(categories.get(index).getId() + ": " + categories.get(index).getName());
	}
    }

}
