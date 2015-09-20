package kickstarter.mvc.interfaces;

import kickstarter.dao.interfaces.iDAO;
import kickstarter.mvc.viewState.ViewValues;
import kickstarter.pages.viewContent.PageView;
import kickstarter.ui.iUserInterface;

public interface iView {

	void addPageView(PageView page);

	void setUserInterface(iUserInterface ui);

	void showPage();

	ViewValues getViewValues();

	void setView(iView setView);

	void setModel(iModel setModel);

	void setIDAO(iDAO idao);
}
