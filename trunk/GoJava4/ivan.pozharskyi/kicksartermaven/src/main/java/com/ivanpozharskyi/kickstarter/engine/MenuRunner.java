package com.ivanpozharskyi.kickstarter.engine;

import java.sql.SQLException;

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

	public void showMenu() throws SQLException {
		menu.setChoise(choice);
		menu.show();
	}
}
