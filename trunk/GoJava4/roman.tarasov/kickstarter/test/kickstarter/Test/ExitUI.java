package kickstarter.Test;

import kickstarter.ui.iUserInterface;

public class ExitUI implements  iUserInterface {

	@Override
	public String inputString() {
		return "e";
	}

	@Override
	public void display(String stringToDisplay) {
		System.out.println(stringToDisplay);
	}
}