package view;

import java.util.ArrayList;

import model.Category;

public class CategoriesPage {
    
    public void showCategories(ArrayList<Category> categories) {
	System.out.println("Select category: ");
	for (int index = 0; index < categories.size(); index++) {
	    System.out.println(categories.get(index).getId() + ": " + categories.get(index).getName());
	}
    }

}
