package goit.nz.kickstarter;

import goit.nz.kickstarter.controller.Kickstarter;

public class Bootstrap {
	private static Kickstarter app;
	
	public static void main(String[] args) {
		DataStorage storage = new DataStorage();
		app = new Kickstarter(storage);
		app.run();
	}
}
