package com.goit.kickstarter.glmax.controller;

import com.goit.kickstarter.glmax.model.*;
import com.goit.kickstarter.glmax.view.*;


public class Kickstarter {

	private Runner runner;

	public Kickstarter(DataSource dataSource) {
		this.runner = new Runner(dataSource);
	}

	public void run() {
		runner.run();
	}

	public static void main(String[] args) {
		DataSource dataSource = new LocalDataSource();

		Kickstarter kickstarter = new Kickstarter(dataSource);
		kickstarter.run();
	}


}
