package com.goit.kickstarter.glmax.controller;

import com.goit.kickstarter.glmax.model.DataSource;
import com.goit.kickstarter.glmax.model.LocalDataSource;
import com.goit.kickstarter.glmax.view.ConsoleIn;
import com.goit.kickstarter.glmax.view.ConsoleOut;
import com.goit.kickstarter.glmax.view.Input;
import com.goit.kickstarter.glmax.view.Output;


public class Kickstarter {

	private Runner runner;
	private static DataSource dataSource;

	public Kickstarter(Output output, Input input, DataSource dataSource) {
		this.runner = new Runner(output, input);
		this.dataSource = dataSource;
	}

	public void run() {
		runner.run();
	}

	public static void main(String[] args) {
		Output output = new ConsoleOut();
		Input input = new ConsoleIn();
		DataSource dataSource = new LocalDataSource();

		Kickstarter kickstarter = new Kickstarter(output, input, dataSource);
		kickstarter.run();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

}
