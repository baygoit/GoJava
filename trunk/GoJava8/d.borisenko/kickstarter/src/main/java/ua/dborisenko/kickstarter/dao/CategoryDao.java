package ua.dborisenko.kickstarter.dao;

import java.util.List;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

public interface CategoryDao {

    public Category getCategoryById(int id);

    public Project getProjectById(int id);

    public List<Category> getCategories();

    public void getQuestions(Project project);

    public void getRewards(Project project);

    public void addInvestment(int projectId, Investment investment);

    public void addQuestion(int projectId, Question question);

    public Category getCategoryByProjectId(int id);
}
