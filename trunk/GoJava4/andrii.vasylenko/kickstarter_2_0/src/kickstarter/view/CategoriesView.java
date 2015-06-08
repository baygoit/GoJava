package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;

public class CategoriesView extends AbstractView {

	@Override
	public State getDirection(int item) {
		if (item == 0) {
			return THE_END;
		}
		return PROJECTS;
	}

	@Override
	protected String getHead() {
		return "---CHOICE CATEGORY---";
	}

	@Override
	protected String getMenu() {
		return String.format("%d - %s\r\n", 0, "EXIT");
	}
}
