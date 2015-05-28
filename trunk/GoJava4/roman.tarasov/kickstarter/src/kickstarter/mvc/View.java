package kickstarter.mvc;

import java.util.ArrayList;
import java.util.List;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.viewState.ViewValues;
import kickstarter.mvc.viewState.iViewState;
import kickstarter.pages.viewContent.PageView;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;
import kickstarter.ui.iUserInterface;

public class View implements iView {
	public iModel imodel;
	public iView iview;
	private PageView page;
	private iUserInterface ui;
	private List<PageView> pagesView;
	private int currentPage;
	private iViewState correct;
	private iViewState error;
	private iViewState state;
	private ViewValues ViewValues;

	public View(iUserInterface ui) {
		correct = new HasCorrectRepository();
		error = new HasRepositoryError();
		ViewValues=new ViewValues();
		state = correct;
		this.ui = ui;
		pagesView = new ArrayList<PageView>();
	}

	class HasRepositoryError implements iViewState {

		@Override
		public void showPage() {
			if (!ViewValues.repositoryError) {
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
			currentPage = IndexOfPage.REPOSITORY_MENU_PAGE.ordinal();
			page = pagesView.get(currentPage);
			ViewValues.repositoryError=true;
			try {
				ui.display(page.getHeader());
				imodel.next(currentPage);
			} catch (RepositoryException e1) {
//TODO throw ViewException
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
	@Override
	public void setView(iView setView) {
		for (PageView pageView : pagesView) {
			pageView.iview = setView;
		}
		this.iview = setView;
	}

	@Override
	public ViewValues getViewValues() {
		return ViewValues;
	}
}
