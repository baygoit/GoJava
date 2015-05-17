package kickstarter.mvc;

public interface iNavigator {
	void pageWillBe(int nextPage);

	void prevPage(int prevPage);

	void setOption(int intOption, String stringOption);

	void saveCategory(int selectedCategory);

	int getSavedCategory();

	void saveProject(int selectedProject);

	void savePageBeforeError(int page);

	int getSavedPage();
}
