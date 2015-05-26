package kickstarter.mvc;

import java.util.ArrayList;
import java.util.List;

import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.mvc.options.ViewOptions;
import kickstarter.pages.viewContent.PageView;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;
import kickstarter.ui.iUserInterface;

public class View implements iView {
	public iModel imodel;
	private PageView page;
	private iUserInterface ui;
	private List<PageView> pagesView;
	private int currentPage;
	

	public View( iUserInterface ui) {
		
		this.ui = ui;
		pagesView = new ArrayList<PageView>();
	}

	@Override
	public void addPageView(PageView page) {
		pagesView.add(page);
	}

	@Override
	public void showPage() {

		currentPage = imodel.getCurrentPage();
		page = pagesView.get(currentPage);
		try {
			ui.display(page.getHeader());
		} catch (RepositoryException e) {

			ui.display("FileSystemRepository error , press any key to continue");
			ViewOptions errorMessage = imodel.getViewOptions();
			errorMessage.viewError = true;
			imodel.setViewOptions(errorMessage);
		}
	}

	@Override
	public void setUserInterface(iUserInterface ui) {
		this.ui = ui;
	}


	@Override
	public void setRepository(iRepository setRepository) {
		for (PageView pageView : pagesView)
			pageView.repository=setRepository;
	}

	@Override
	public void setModel(iModel setModel) {
		for (PageView pageView : pagesView){
			pageView.imodel=setModel;
		}
			this.imodel=setModel;
		
	}
}
