package kickstarter.mvc.interfaces;

import kickstarter.pages.viewContent.PageView;
import kickstarter.ui.iUserInterface;

public interface iView {
	void showPage();

	void addPageView(PageView page);
	void setUserInterface(iUserInterface ui);
}
