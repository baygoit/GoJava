package kickstarter.mvc;

import kickstarter.pages.PageView;
import kickstarter.pages.model.PageModel;

public class Controller {

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
