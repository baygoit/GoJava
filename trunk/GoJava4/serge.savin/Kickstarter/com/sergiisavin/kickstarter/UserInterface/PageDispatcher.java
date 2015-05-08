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
			page.injectKickcstarter(kickstarter);
			page.injectPageDispatcher(this);
			page.constructPage();
			page.show();
			break;
		case MAIN_MENU_PAGE:
			page = new MainMenuPage(printer);
			page.injectKickcstarter(kickstarter);
			page.injectPageDispatcher(this);
			page.constructPage();
			page.show();
			break;
		case WELCOME_PROJECT_OWNER_PAGE:
			page = new WelcomeProjectOwnerPage(printer);
			page.injectKickcstarter(kickstarter);
			page.injectPageDispatcher(this);
			page.constructPage();
			page.show();
			break;
		case CATEGORIES_PAGE:
			page = new CategoriesPage(printer);
			page.injectKickcstarter(kickstarter);
			page.injectPageDispatcher(this);
			page.constructPage();
			page.show();
			break;
			
			default:
				
		}
	}

	public void injectPrinter(Printer printer) {
		this.printer = printer;
		
	}
	
}
