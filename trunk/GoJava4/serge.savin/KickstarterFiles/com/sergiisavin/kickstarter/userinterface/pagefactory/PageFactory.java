package com.sergiisavin.kickstarter.userinterface.pagefactory;

import com.sergiisavin.kickstarter.userinterface.pages.CategoriesPage;
import com.sergiisavin.kickstarter.userinterface.pages.DetailedProjectDescriptionPage;
import com.sergiisavin.kickstarter.userinterface.pages.MainMenuPage;
import com.sergiisavin.kickstarter.userinterface.pages.Page;
import com.sergiisavin.kickstarter.userinterface.pages.PageType;
import com.sergiisavin.kickstarter.userinterface.pages.ProjectsPage;
import com.sergiisavin.kickstarter.userinterface.pages.WelcomeProjectOwnerPage;
import com.sergiisavin.kickstarter.userinterface.pages.WelcomeUserPage;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.requestdata.RequestData;

public class PageFactory {
	
	private Printer printer;
	
	public PageFactory(Printer printer){
		this.printer = printer;
	}
	
	public PageFactory(){}
	
	public void setPrinter(Printer printer){
		this.printer = printer;
	}

	public Page createPage(PageType pageType, Printer printer, RequestData request) {
		Page result = null;
		switch(pageType){
		case WELCOME_USER_PAGE:
			result = new WelcomeUserPage(printer);
			break;
		case MAIN_MENU_PAGE:
			result = new MainMenuPage(printer);
			break;
		case WELCOME_PROJECT_OWNER_PAGE:
			result = new WelcomeProjectOwnerPage(printer);
			break;
		case CATEGORIES_PAGE:
			result = new CategoriesPage(printer);
			break;
		case PROJECTS_PAGE:
			result = new ProjectsPage(printer, request);
			break;
		case DETAILED_PROJECT_DESCRIPTION_PAGE:
			result = new DetailedProjectDescriptionPage(printer, request);
			break;
			default:
				
		}
		return result;
	}
	
	public Page createPage(PageType pageType){
		return createPage(pageType, printer, null);
	}

}
