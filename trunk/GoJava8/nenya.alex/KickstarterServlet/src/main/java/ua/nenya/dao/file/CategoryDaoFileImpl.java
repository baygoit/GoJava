package ua.nenya.dao.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
	

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public List<Category> initCategories() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			categories = mapper.readValue(new File(fileName), new TypeReference<List<Category>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return categories;

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
