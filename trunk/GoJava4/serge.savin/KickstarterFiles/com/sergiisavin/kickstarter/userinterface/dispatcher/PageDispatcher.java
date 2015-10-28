package com.sergiisavin.kickstarter.userinterface.dispatcher;

import com.sergiisavin.kickstarter.Kickstarter;
import com.sergiisavin.kickstarter.userinterface.pagefactory.PageFactory;
import com.sergiisavin.kickstarter.userinterface.pages.Page;
import com.sergiisavin.kickstarter.userinterface.pages.PageType;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.requestdata.RequestData;

public class PageDispatcher {

	private Kickstarter kickstarter;
	private Printer printer;
	private PageFactory pageFactory;

	public PageDispatcher(Printer printer) {
		this.printer = printer;
	}
	
	public PageDispatcher(){}

	public void setKickstarter(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}
	
	public void setPageFactory(PageFactory factory){
		this.pageFactory = factory;
	}

	public void requestPage(PageType pageType, RequestData request) {
		Page page = pageFactory.createPage(pageType, printer, request);
		startPage(page);		
	}

	private void startPage(Page page) {
		page.injectKickcstarter(kickstarter);
		page.injectPageDispatcher(this);
		page.constructPage();
		page.show();
	}

	public void injectPrinter(Printer printer) {
		this.printer = printer;
		
	}
	
}
