package kickstarter.mvc;

import java.util.ArrayList;
import java.util.List;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.pages.viewContent.PageView;
import kickstarter.pages.viewContent.state.iViewState;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;
import kickstarter.ui.iUserInterface;

public class View implements iView {
	public iModel imodel;
	private PageView page;
	private iUserInterface ui;
	private List<PageView> pagesView;
	private int currentPage;
	iViewState correct;
	iViewState error;
	iViewState state;

	public View(iUserInterface ui) {
		correct = new HasCorrectRepository();
		error = new HasRepositoryError();
		state = correct;
		this.ui = ui;
		pagesView = new ArrayList<PageView>();
	}

	class HasRepositoryError implements iViewState {

		@Override
		public void showPage() {
			if (!imodel.getViewOptions().viewError) {
				state = correct;
				state.showPage();
			}
		}
	}

	class HasCorrectRepository implements iViewState {
		@Override
		public void showPage() {
			currentPage = imodel.getCurrentPage();
			page = pagesView.get(currentPage);
			try {
				ui.display(page.getHeader());
			} catch (RepositoryException e) {
				state = error;
				repositoryError();
				return;
			}
		}

		void repositoryError() {
			currentPage = imodel.getRepositoryErrorPageIndex();
			page = pagesView.get(currentPage);
			imodel.getViewOptions().viewError=true;
			try {
				ui.display(page.getHeader());
				imodel.next(currentPage);
			} catch (RepositoryException e1) {

				e1.printStackTrace();
			}
		}
	}

	@Override
	public void addPageView(PageView page) {
		pagesView.add(page);
	}

	@Override
	public void showPage() {
		state.showPage();

	}

	@Override
	public void setUserInterface(iUserInterface ui) {
		this.ui = ui;
	}

	@Override
	public void setRepository(iRepository setRepository) {
		for (PageView pageView : pagesView)
			pageView.repository = setRepository;
	}

	@Override
	public void setModel(iModel setModel) {
		for (PageView pageView : pagesView) {
			pageView.imodel = setModel;
		}
		this.imodel = setModel;
	}
}
