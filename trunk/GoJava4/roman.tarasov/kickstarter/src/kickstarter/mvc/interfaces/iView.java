package kickstarter.mvc.interfaces;

import kickstarter.mvc.viewState.ViewValues;
import kickstarter.pages.viewContent.PageView;
import kickstarter.repository.facade.iRepository;
import kickstarter.ui.iUserInterface;

public interface iView {

	void addPageView(PageView page);

	void setUserInterface(iUserInterface ui);

	void setRepository(iRepository setRepository);

	void showPage();

	ViewValues getViewValues();

	void setView(iView setView);

	void setModel(iModel setModel);
}
