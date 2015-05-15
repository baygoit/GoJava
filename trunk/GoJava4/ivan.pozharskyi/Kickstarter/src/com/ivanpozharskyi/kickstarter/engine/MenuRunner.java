package com.ivanpozharskyi.kickstarter.engine;

import com.ivanpozharskyi.kickstarter.userinterface.*;

public class MenuRunner {
	private Menu menu;
	private Object choice;

	public void setMenu(Menu menu) {
		this.menu = menu;

	}

	public void setChoise(Object choice) {
		this.choice = choice;
	}

	public void showMenu() {
		menu.setChoise(choice);
		menu.show();
	}
}
