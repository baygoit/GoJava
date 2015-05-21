package kickstarter.mvc;

import kickstarter.mvc.interfaces.iController;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.pages.model.PageModel;
import kickstarter.pages.view.PageView;


public class Controller implements iController{

	private View view;
	private iModel imodel;

	public Controller(View view, Model model) {
		this.view = view;
		this.imodel = model;
	}

	public void printView() {
		view.print();
	}

	public void update(String command) {
		imodel.update(command);
	}

	public void setPage(int pageIndex) {
		imodel.setPage(pageIndex);
	}

	public void add(PageView pageView, PageModel pagesModel) {
		imodel.add(pageView, pagesModel);

	}
}
