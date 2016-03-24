package site;

import categories.Kickstarter;
import usermanager.ConsoleManager;

public abstract class Page {
		
	static final String FIRST_CHOICE = "1";
	static final String SECOND_CHOICE = "2";
	static final String THIRD_CHOICE = "3";
	static final String PREVIOUS_PAGE = "p";
	static final String EXIT = "0";
	static final String PARADOX = "PARADOX";
	static final String SOPHISM = "SOPHISM";
	static final String APORIA = "APORIA";
	static final String DECORATION = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

	public ConsoleManager console = new ConsoleManager();
	public Page direction;
	public Kickstarter kickstarter;

	Page(Kickstarter kickstarter){
		this.kickstarter = kickstarter;
	}

	public abstract void openPage();

	abstract void openPreviousPage();

	abstract void showVision();

	void exit() {
		console.write("Thank You for visit! Bye!");
		console.write(",,,^._.^,,,");
		System.exit(0);
	}
	boolean isInteger(String s) {
		boolean isValidInteger = false;
		try {
			Integer.parseInt(s);
			isValidInteger = true;
		} catch (NumberFormatException ex) {

		}

		return isValidInteger;
	}
}
