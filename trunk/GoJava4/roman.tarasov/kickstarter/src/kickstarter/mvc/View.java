package kickstarter.mvc;

import kickstarter.pages.PageView;
import kickstarter.ui.iUserInterface;

public class View {
	iModel dispatcher;
	PageView page;
	final int OK=0;
	private iUserInterface ui;

	public View(iModel dispatcher, iUserInterface ui) {
		this.dispatcher = dispatcher;
		this.ui = ui;
	}

	public void print() {
		page = dispatcher.getPage();
		String header=page.getHeader();
		ui.display(header);
	}
}
