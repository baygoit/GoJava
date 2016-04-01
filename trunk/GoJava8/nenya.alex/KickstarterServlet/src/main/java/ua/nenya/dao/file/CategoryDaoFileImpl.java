package ua.nenya.dao.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Question;
import ua.nenya.project.Reward;
import ua.nenya.dao.CategoryDao;

public class CategoryDaoFileImpl implements CategoryDao {
	private List<Category> categories = new ArrayList<Category>();
	private String fileName = "C:/workspace/GoJava8/KickstarterServlet/src/main/resources/caterories.json";
	//private String fileName = "src/main/resources/caterories.json";
	

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Category> getCategories() {
		Collections.sort(categories, new Comparator<Category>() {

			@Override
			public int compare(Category category1, Category category2) {
				return category1.getName().compareTo(category2.getName());
			}
		});
		return categories;
	}

	@Override
	public void initCategories() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			categories = mapper.readValue(new File(fileName), new TypeReference<List<Category>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@Override
	public List<Project> initProjects(Category category) {
		List<Project> projects = category.getProjects();
		Collections.sort(projects, new Comparator<Project>() {

			@Override
			public int compare(Project project1, Project project2) {
				return project1.getName().compareTo(project2.getName());
			}
		});
		return projects;
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
