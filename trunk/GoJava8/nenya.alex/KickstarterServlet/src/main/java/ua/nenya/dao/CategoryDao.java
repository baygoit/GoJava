package ua.nenya.dao;

import java.util.List;

import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Question;
import ua.nenya.project.Reward;

public interface CategoryDao {
	List<Category> initCategories();
	List<Project> initProjects(Category category);
	List<Reward> initRewards(Project project);
	List<Question> initQuestions(Project project);
	void writeQuestionInProject(String projectName, String question);
	void writeIvestmentInProject(String projectName, int amount);
	Project getProjectByName(String projectName);
}
