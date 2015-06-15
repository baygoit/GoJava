package vadya_zakusylo.kickstarter.model;

import java.util.List;

public interface Model {

	Quote getQuote();

	List<Category> selectCategories();

	void setCategory(Category category);

	Category getCategory();

	List<Project> selectProjects(Category category);

	void setProject(Project project);

	Project getProject();

	void setCurrentMoneySynchronized(double money);

	void setQuestion(String question);

}
