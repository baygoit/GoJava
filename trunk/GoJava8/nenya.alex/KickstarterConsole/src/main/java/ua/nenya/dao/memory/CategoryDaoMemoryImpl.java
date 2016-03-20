package ua.nenya.dao.memory;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.dao.CategoryDao;

public class CategoryDaoMemoryImpl implements CategoryDao{
	
	private List<Category> categories = new ArrayList<Category>();
	private File file = new File("src/main/resources/caterories.json");

	public void setFile(File file) {
		this.file = file;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	 public CategoryDaoMemoryImpl(){
		 
	 }
	 
	@Override
	public void initCategories() {
			Category categoryMusic = new Category("Music");
			categoryMusic.getProjects().add(new Project("A new funny song", "We want to write a new funny song!",
					2000, 1000, 7));
			categoryMusic.getProjects().add(new Project("A lonly song", "We want to write a new sad song!", 400,
					10, 3));
			categories.add(categoryMusic);
			
			Category categoryFilms = new Category("Films");
			categoryFilms.getProjects().add(new Project("Terminator 88",
					"All money we'll gather is for new blockbuster!", 200000, 1000,
					365));
			categoryFilms.getProjects().add(new Project("Dirty Garry", "It'll be a western about wild west!",
					10000, 3000, 150));
			categories.add(categoryFilms);
			
			Category categoryArt = new Category("Art");
			categoryArt.getProjects().add(new Project("Exhibition of photos", "Exhibition of photos of Kiev!",
					7000, 1000, 15));
			categoryArt.getProjects().add(new Project("Exhibition of plates", "Exhibition of old plates!",
					100000, 7000, 120));
			categories.add(categoryArt);
			
			if(file.length() == 0){
			convertToJSON(categories);
			}
	}
	 
	 private void convertToJSON(Object object) {

		ObjectMapper mapper = new ObjectMapper();
		 try {
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			mapper.writeValue(file, object);
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}
