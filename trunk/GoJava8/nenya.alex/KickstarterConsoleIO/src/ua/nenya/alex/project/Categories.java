package ua.nenya.alex.project;

import java.util.ArrayList;
import java.util.List;

public class Categories {
	
	private List<Category> categories = new ArrayList<Category>();

	public List<Category> getCategories() {
		return categories;
	}
	
	 public Categories(){
		 
	 }
	 
	 public void init(){
		 Category categoryMusic = new Category("Music");
		 categories.add(categoryMusic);
		 Category categoryFilms = new Category("Films");
		 categories.add(categoryFilms);
		 Category categoryBooks = new Category("Books");
		 categories.add(categoryBooks);
		 Category categoryArt = new Category("Art");
		 categories.add(categoryArt);
		 Category categoryGames = new Category("Games");
		 categories.add(categoryGames);
		 Category categoryCreate = new Category("Create a project");
		 categories.add(categoryCreate);
	 }
}
