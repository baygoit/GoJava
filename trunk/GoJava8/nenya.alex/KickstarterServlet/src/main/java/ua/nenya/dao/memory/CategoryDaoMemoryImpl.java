package ua.nenya.dao.memory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Question;
import ua.nenya.project.Reward;
import ua.nenya.dao.CategoryDao;

public class CategoryDaoMemoryImpl implements CategoryDao {

	private List<Category> categories = new ArrayList<Category>();
	private File file = new File("C:/workspace/GoJava8/KickstarterServlet/src/main/resources/caterories.json");

	public void setFile(File file) {
		this.file = file;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public CategoryDaoMemoryImpl() {

	}

	@Override
	public List<Category> initCategories() {
		Reward reward1 = new Reward();
		reward1.setName("100$");
		reward1.setDescription("Invest one hundred dollars and get bottle of water!!!");
		reward1.setAmount(100);
		Reward reward11 = new Reward();
		reward11.setName("100$");
		reward11.setDescription("Invest one hundred dollars and get five bottles of water!!!");
		reward11.setAmount(100);
		Reward reward2 = new Reward();
		reward2.setName("200$");
		reward2.setDescription("Invest two hundreds dollars and get two tickets to the movie!!!");
		reward2.setAmount(200);
		Reward reward22 = new Reward();
		reward22.setName("200$");
		reward22.setDescription("Invest two hundreds dollars and get tickets to the movie for all family!!!");
		reward22.setAmount(200);
		Reward reward5 = new Reward();
		reward5.setName("500$");
		reward5.setDescription("Invest five hundreds dollars and get a lunch for two persons in the restaurant!!!");
		reward5.setAmount(500);
		

		Category categoryMusic = new Category();
		categoryMusic.setName("Music");
		Project project1 = new Project();
		project1.setName("A new funny song");
		project1.setDescription("We want to write a new funny song!");
		project1.setNeededAmount(2000);
		project1.setAvailableAmount(1000);
		project1.setDaysRemain(7);
		project1.getRewards().add(reward1);
		project1.getRewards().add(reward11);
		project1.getRewards().add(reward2);
		project1.getRewards().add(reward22);
		project1.getRewards().add(reward5);
		
		Project project2 = new Project();
		project2.setName("A lonly song");
		project2.setDescription("We want to write a new sad song!");
		project2.setNeededAmount(400);
		project2.setAvailableAmount(10);
		project2.setDaysRemain(3);
		project2.getRewards().add(reward1);
		project2.getRewards().add(reward2);
		project2.getRewards().add(reward5);
		
		categoryMusic.getProjects().add(project1);
		categoryMusic.getProjects().add(project2);
		categories.add(categoryMusic);

		Category categoryFilms = new Category();
		categoryFilms.setName("Films");
		Project project3 = new Project();
		project3.setName("Terminator 88");
		project3.setDescription("All money we'll gather is for new blockbuster!");
		project3.setNeededAmount(200000);
		project3.setAvailableAmount(1000);
		project3.setDaysRemain(365);
		project3.getRewards().add(reward1);
		project3.getRewards().add(reward2);
		project3.getRewards().add(reward22);
		
		Project project4 = new Project();
		project4.setName("Dirty Garry");
		project4.setDescription("It'll be a western about wild west!");
		project4.setNeededAmount(10000);
		project4.setAvailableAmount(3000);
		project4.setDaysRemain(150);
		project4.getRewards().add(reward1);
		project4.getRewards().add(reward11);
		
		categoryFilms.getProjects().add(project3);
		categoryFilms.getProjects().add(project4);
		categories.add(categoryFilms);

		Category categoryArt = new Category();
		categoryArt.setName("Art");
		Project project5 = new Project();
		project5.setName("Exhibition of photos");
		project5.setDescription("Exhibition of photos of Kiev!");
		project5.setNeededAmount(7000);
		project5.setAvailableAmount(1000);
		project5.setDaysRemain(15);
		project5.getRewards().add(reward1);
		project5.getRewards().add(reward11);
		project5.getRewards().add(reward2);
		project5.getRewards().add(reward22);
		project5.getRewards().add(reward5);
		Project project6 = new Project();
		project6.setName("Exhibition of plates");
		project6.setDescription("Exhibition of old plates!");
		project6.setNeededAmount(100000);
		project6.setAvailableAmount(7000);
		project6.setDaysRemain(120);
		project6.getRewards().add(reward2);
		project6.getRewards().add(reward22);
		project6.getRewards().add(reward5);
		categoryArt.getProjects().add(project5);
		categoryArt.getProjects().add(project6);
		categories.add(categoryArt);

		if (file.length() == 0 || !file.exists()) {
			convertToJSON(categories);
		}
		return categories;
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

	@Override
	public List<Project> initProjects(Category category) {
		return category.getProjects();
		
	}

	@Override
	public List<Reward> initRewards(Project project) {
		return project.getRewards();
		
		
	}


	@Override
	public List<Question> initQuestions(Project project) {
		return project.getQuestions();
	}

	@Override
	public void writeQuestionInProject(Project project, Question question) {
		project.getQuestions().add(question);
	}

	@Override
	public void writeIvestmentInProject(Project project, int amount) {
		int previousAmount = project.getAvailableAmount();
		project.setAvailableAmount(previousAmount+amount);
	}
}
