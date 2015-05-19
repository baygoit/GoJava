package kickstarter.mvc;

public interface iNavigator {
	void next(int page);

	void setOption(int intOption, String stringOption);

	void saveCategory(int selectedCategory);

	int getSavedCategory();

	void savePageBeforeError(int page);

	int getSavedPage();

	void goToAndBack(int toPage, int back);

	void nextWithOptions(int page, int iOption, String sOption);
}
