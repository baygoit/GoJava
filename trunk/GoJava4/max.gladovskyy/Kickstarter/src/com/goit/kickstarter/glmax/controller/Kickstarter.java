package com.goit.kickstarter.glmax.controller;

import com.goit.kickstarter.glmax.model.*;
import com.goit.kickstarter.glmax.view.*;

public class Kickstarter {

	public static void main(String[] args) {
		DataSource dataSource = new LocalDataSource();

		Runner kickstarter = new Runner(dataSource);
		kickstarter.run();
	}

}
