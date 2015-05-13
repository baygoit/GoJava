package kickstarter.Test;

import kickstarter.UserInterface;


public class ExitUI implements  UserInterface {

	@Override
	public String inputString() {

		return "e";
	}

	@Override
	public void display(String stringToDisplay) {
		System.out.println(stringToDisplay);

	}

}