package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Category;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;
import ua.nenya.domain.Reward;

public interface CategoryDao {
	List<Category> getCategories();
	List<Project> getProjects(String categoryName);
	List<Reward> getRewards(String projectName);
	List<Question> getQuestions(String projectName);
	void writeQuestionInProject(String projectName, String question);
	void writeIvestmentInProject(String projectName, int amount);
	Project getProjectByName(String projectName);
}
