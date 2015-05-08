package com.ivanpozharskyi.kickstarter.engine;

import com.ivanpozharskyi.kickstarter.datastorage.CategoryStorage;
import com.ivanpozharskyi.kickstarter.datastorage.ProjectStorage;
import com.ivanpozharskyi.kickstarter.userinterface.Menu;

public class MenuController {
	private MenuRunner menuRunner;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;
	private Reader reader;
	private Menu previousMenu;
	MenuController(){
		menuRunner = new MenuRunner();
		previousMenu = menuRunner.getPreviousMenu();
		if(previousMenu == MenuMain)
	}
}
