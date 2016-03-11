package ua.nenya.dao.memory;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ua.nenya.dao.CategoryDao;
import ua.nenya.project.Category;

public class CategoryDaoMemoryImpl implements CategoryDao{
	
	private List<Category> categories = new ArrayList<Category>();
	private ObjectMapper mapper = new ObjectMapper();

	public List<Category> getCategories() {
		return categories;
	}
	
	 public CategoryDaoMemoryImpl(){
		 
	 }
	 
	@Override
	public void initCategories() {
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
			
			convertToJSON(categories);
	}
	 
	 public void convertToJSON(Object object) {
		 try {
			mapper.writeValue(new FileWriter("src/resources/caterories.json"), object);
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}
