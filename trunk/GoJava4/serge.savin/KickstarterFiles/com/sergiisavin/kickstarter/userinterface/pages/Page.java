package com.sergiisavin.kickstarter.userinterface.pages;

import com.sergiisavin.kickstarter.Kickstarter;
import com.sergiisavin.kickstarter.userinterface.dispatcher.PageDispatcher;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.requestdata.RequestData;

public class Page {

	protected Kickstarter kickstarter;
	protected PageDispatcher dispatcher;
	
	protected Printer printer;
	
	protected String header;
	protected String dataArea;
	protected String footer;
	protected String whereAmI;
	
	protected String input;
	
	protected PageType nextPage;
	protected PageType previousPage;
	protected RequestData requestData; 
	
	public Page(){
	
	}
	
	
	public Page(Printer printer) {
		this.printer = printer;
	}


	public void constructPage(){
		header = "/////////////////////////////////\n"+
				 "//          HEADER             //\n"+
				 "////////////////////////////////\n";
		dataArea = "\n" + 
				   "/////////////////////////////////\n"+
				   "//          DATA AREA          //\n"+
				   "////////////////////////////////\n";
		footer =   "\n" + 
				   "/////////////////////////////////\n"+
				   "//          FOOTER             //\n"+
				   "////////////////////////////////\n";
		whereAmI = "Page > :";

	}
	
	public void show(){
		printer.print(header);
		printer.print(dataArea);
		printer.print(footer);
		printer.print(whereAmI);
		getInput();
		dispatcher.requestPage(nextPage, requestData);
	}

	protected void getInput() {
		
	}

	public void injectKickcstarter(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}

	public void injectPageDispatcher(PageDispatcher pageDispatcher) {
		dispatcher = pageDispatcher;
	}
}
