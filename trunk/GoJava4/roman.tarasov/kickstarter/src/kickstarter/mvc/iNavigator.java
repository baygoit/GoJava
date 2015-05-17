package kickstarter.mvc;

public interface iNavigator {
	void pageWillBe(int nextPage);

	void prevPage(int prevPage);

	void setOption(int intOption, String stringOption);
}
