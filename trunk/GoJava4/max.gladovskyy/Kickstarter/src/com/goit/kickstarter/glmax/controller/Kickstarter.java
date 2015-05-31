package com.goit.kickstarter.glmax.controller;

import com.goit.kickstarter.glmax.model.*;
import com.goit.kickstarter.glmax.view.*;

public class Kickstarter {

	public static void main(String[] args) {
		DataSource dataSource = new LocalDataSource();
		View view = new ConsoleView();

		Runner kickstarter = new Runner(dataSource, view);
		kickstarter.run();
	}

}
