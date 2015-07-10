package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.dao.MockDataProvider;
import com.tyomsky.kickstarter.ui.Console;

public class BootStrap {

	public static void main(String[] args) {
        DataProvider dataProvider = new MockDataProvider();
        Console console = new Console();
        Configuration configuration= new Configuration();
        configuration.setDataProvider(dataProvider);
        configuration.setOutput(console);
        Kickstarter runner = new Kickstarter(console, configuration.getControllersConfiguration());
		runner.run();
	}

}
