package kickstarter.mvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.viewState.ViewValues;
import kickstarter.mvc.viewState.iViewState;
import kickstarter.pages.viewContent.PageView;
import kickstarter.ui.iUserInterface;

public class View implements iView {
	private iModel imodel;
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
		ViewValues = new ViewValues();
		state = correct;
		this.ui = ui;
		pagesView = new ArrayList<PageView>();
	}

	class HasRepositoryError implements iViewState {

		@Override
		public void showPage() {
			if (!ViewValues.getRepositoryError()) {
				state = correct;
				state.showPage();
			}
			try {
				imodel.setPage(IndexOfPage.DAO_MENU_PAGE.ordinal());
				currentPage = imodel.getCurrentPage();
				page = pagesView.get(currentPage);
				ui.display(page.getHeader());
			} catch (ServiceException | SQLException e) {
				// TODO throw ViewException
				e.printStackTrace();
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
			} catch (ServiceException | SQLException e) {
				state = error;
				repositoryError();
			}
		}

		void repositoryError() {
			currentPage = IndexOfPage.DAO_MENU_PAGE.ordinal();
			page = pagesView.get(currentPage);
			ViewValues.setRepositoryError(true);
			try {
				ui.display(page.getHeader());
				imodel.next(currentPage);
			} catch (ServiceException | SQLException e1) {
				// TODO throw ViewException
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
	public void setModel(iModel setModel) {
		for (PageView pageView : pagesView) {
			pageView.setImodel(setModel);
		}
		this.imodel = setModel;
	}

	@Override
	public void setView(iView setView) {
		for (PageView pageView : pagesView) {
			pageView.setIview(setView);
		}
	}

	@Override
	public ViewValues getViewValues() {
		return ViewValues;
	}
	@Override
	public void setIDAO(iDAO idao) {
		for (PageView pageView : pagesView) {
			pageView.setIDAO(idao);
		}
	}
}
