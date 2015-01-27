package org.goJava2.kickstarter.main;

import org.goJava2.kickstarter.model.Scann;
import org.goJava2.kickstarter.view.Kickstarter;

public class LaunchApp {

	public static void main(String[] args) {
		Kickstarter app = new Kickstarter();
		app.showQuote();
		app.showCategorys();
		System.out.print("> Select your category: ");
		app.selectCategry(new Scann().choise());
		app.showSpecificProj();
		System.out.print("> Select your project: ");
		app.selectProject(new Scann().choise());
	}
}