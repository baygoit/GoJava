package com.sergiisavin.kickstarter;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.sergiisavin.kickstarter.userinterface.dispatcher.PageDispatcher;
import com.sergiisavin.kickstarter.userinterface.pages.CategoriesPage;
import com.sergiisavin.kickstarter.userinterface.pages.ProjectsPage;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.printer.UpperCaseConsolePrinter;
import com.sergiisavin.kickstarter.userinterface.requestdata.RequestData;


public class ProjectsPageTest {

	@Test
	public void test() {
		Kickstarter kickstarterMock = mock(Kickstarter.class);
		when(kickstarterMock.getProjectsByCategory("Toys")).thenReturn(new String[] {"Project1", "Project2"});
		
		PageDispatcher dispatcherMock = mock(PageDispatcher.class);
		
		Printer printer = new UpperCaseConsolePrinter();
		RequestData request = new RequestData("Toys");
		
		ProjectsPage page = new ProjectsPage(printer, request);
		
		page.injectKickcstarter(kickstarterMock);
		page.injectPageDispatcher(dispatcherMock);
		
		page.constructPage();
		//page.show();
	}

}
