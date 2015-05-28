package kickstarter.mvc.interfaces;

import kickstarter.mvc.viewState.ViewOptions;
import kickstarter.pages.viewContent.PageView;
import kickstarter.repository.facade.iRepository;
import kickstarter.ui.iUserInterface;

public interface iView  {

	void addPageView(PageView page);

	void setUserInterface(iUserInterface ui);

	void setRepository(iRepository setRepository);

	void setModel(iModel setModel);

	void showPage();

	ViewOptions getViewOptions();

	void setView(iView setView);
}
