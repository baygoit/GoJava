package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.controller.Kickstarter;
import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.dao.MockDataProvider;
import com.tyomsky.kickstarter.view.Console;
import com.tyomsky.kickstarter.view.ConsoleViewFactory;
import com.tyomsky.kickstarter.view.ViewFactory;

public class BootStrap {

	public static void main(String[] args) {
        DataProvider dataProvider = new MockDataProvider();
        Console console = new Console();
        ViewFactory viewFactory = new ConsoleViewFactory(dataProvider);
        Kickstarter runner = new Kickstarter(console, console, viewFactory, dataProvider);
		runner.run();
	}

}
