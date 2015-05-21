package kickstarter.mvc;

import java.util.ArrayList;
import java.util.List;

import kickstarter.mvc.interfaces.iController;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.pages.view.PageView;
import kickstarter.ui.iUserInterface;

public class View implements iView {
	iModel imodel;
	PageView page;
	iController icontroller;
	final int OK = 0;
	private iUserInterface ui;
	List<PageView> pagesView;

	public View(iModel dispatcher, iUserInterface ui) {
		this.imodel = dispatcher;
		this.ui = ui;
		pagesView=new ArrayList<PageView>();
	}
	@Override
	public void addPageView(PageView page) {
		pagesView.add(page);
		
	}
	@Override
	public void print() {
		page = imodel.getPage();
		String header = page.getHeader();
		ui.display(header);
	}


}
