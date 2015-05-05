package com.sergiisavin.kickstarter.UserInterface;

import com.sergiisavin.kickstarter.Kickstarter;

public class Page {

	protected Kickstarter kickstarter;
	protected PageDispatcher dispatcher;
	
	protected String header;
	protected String dataArea;
	protected String footer;
	protected String whereAmI;
	
	protected String input;
	
	protected PageType nextPage;
	protected PageType previousPage;
	
	public Page(){
	
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
		System.out.print(header);
		System.out.print(dataArea);
		System.out.print(footer);
		System.out.print(whereAmI);
		getInput();
		dispatcher.requestPage(nextPage);
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
