package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;

public class ProjectsView extends AbstractView {

	@Override
	public State getDirection(int item) {
		if (item == 0) {
			return CATEGORIES;
		}
		return PROJECT;
	}

	@Override
	protected String getHead() {
		return "---CHOICE PROJECT---";
	}

	@Override
	protected String getMenu() {
		return String.format("%d - %s\r\n", 0, "EXIT");
	}
}
