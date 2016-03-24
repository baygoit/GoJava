package ua.dborisenko.kickstarter.dao;

import java.util.List;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

public interface CategoryDao {

    public Category getByName(String name);

    public List<String> getCategoryNames();

    public void getQuestions(Project project);

    public void getRewards(Project project);

    public void addInvestment(Project project, Investment investment);

    public void addQuestion(Project project, Question question);
}
