package com.sergiisavin.kickstarter.UserInterface;

import com.sergiisavin.kickstarter.Kickstarter;

public class PageDispatcher {

	private Kickstarter kickstarter;
	private Printer printer;

	public PageDispatcher(Printer printer) {
		this.printer = printer;
	}
	
	public PageDispatcher(){}

	public void setKickstarter(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
	}

	public void requestPage(PageType pageType) {
		Page page = null;
		switch(pageType){
		case WELCOME_USER_PAGE:
			page = new WelcomeUserPage(printer);
			startPage(page);
			break;
		case MAIN_MENU_PAGE:
			page = new MainMenuPage(printer);
			startPage(page);
			break;
		case WELCOME_PROJECT_OWNER_PAGE:
			page = new WelcomeProjectOwnerPage(printer);
			startPage(page);
			break;
		case CATEGORIES_PAGE:
			page = new CategoriesPage(printer);
			startPage(page);
			break;
			
			default:
				
		}
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
