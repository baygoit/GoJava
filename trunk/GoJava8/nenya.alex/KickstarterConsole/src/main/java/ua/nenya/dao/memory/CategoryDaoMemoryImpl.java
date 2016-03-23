package ua.nenya.dao.memory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Reward;
import ua.nenya.dao.CategoryDao;

public class CategoryDaoMemoryImpl implements CategoryDao {

	private List<Category> categories = new ArrayList<Category>();
	private File file = new File("src/main/resources/caterories.json");

	public void setFile(File file) {
		this.file = file;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public CategoryDaoMemoryImpl() {

	}

	@Override
	public void initCategories() {
		Reward reward1 = new Reward("100$", "Invest one hundred dollars and get bottle of water!!!");
		reward1.setAmount(100);
		Reward reward11 = new Reward("100$", "Invest one hundred dollars and get five bottles of water!!!");
		reward11.setAmount(100);
		Reward reward2 = new Reward("200$", "Invest two hundreds dollars and get two tickets to the movie!!!");
		reward2.setAmount(200);
		Reward reward22 = new Reward("200$",
				"Invest two hundreds dollars and get tickets to the movie for all family!!!");
		reward22.setAmount(200);
		Reward reward5 = new Reward("500$",
				"Invest five hundreds dollars and get a lunch for two persons in the restaurant!!!");
		reward5.setAmount(500);
		

		Category categoryMusic = new Category("Music");
		Project project1 = new Project("A new funny song", "We want to write a new funny song!", 2000, 1000, 7);
		project1.getRewards().add(reward1);
		project1.getRewards().add(reward11);
		project1.getRewards().add(reward2);
		project1.getRewards().add(reward22);
		project1.getRewards().add(reward5);
		
		Project project2 = new Project("A lonly song", "We want to write a new sad song!", 400, 10, 3);
		project2.getRewards().add(reward1);
		project2.getRewards().add(reward2);
		project2.getRewards().add(reward5);
		
		categoryMusic.getProjects().add(project1);
		categoryMusic.getProjects().add(project2);
		categories.add(categoryMusic);

		Category categoryFilms = new Category("Films");
		Project project3 = new Project("Terminator 88", "All money we'll gather is for new blockbuster!", 200000, 1000, 365);
		project3.getRewards().add(reward1);
		project3.getRewards().add(reward2);
		project3.getRewards().add(reward22);
		
		Project project4 = new Project("Dirty Garry", "It'll be a western about wild west!", 10000, 3000, 150);
		project4.getRewards().add(reward1);
		project4.getRewards().add(reward11);
		
		categoryFilms.getProjects().add(project3);
		categoryFilms.getProjects().add(project4);
		categories.add(categoryFilms);

		Category categoryArt = new Category("Art");
		Project project5 = new Project("Exhibition of photos", "Exhibition of photos of Kiev!", 7000, 1000, 15);
		project5.getRewards().add(reward1);
		project5.getRewards().add(reward11);
		project5.getRewards().add(reward2);
		project5.getRewards().add(reward22);
		project5.getRewards().add(reward5);
		Project project6 = new Project("Exhibition of plates", "Exhibition of old plates!", 100000, 7000, 120);
		project6.getRewards().add(reward2);
		project6.getRewards().add(reward22);
		project6.getRewards().add(reward5);
		categoryArt.getProjects().add(project5);
		categoryArt.getProjects().add(project6);
		categories.add(categoryArt);

		if (file.length() == 0) {
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
