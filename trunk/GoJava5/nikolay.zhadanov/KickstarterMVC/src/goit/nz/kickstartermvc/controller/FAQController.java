package goit.nz.kickstartermvc.controller;

import goit.nz.kickstartermvc.DispatcherListener;
import goit.nz.kickstartermvc.view.FAQView;

public class FAQController implements DispatcherListener {
	private ProjectController parentController;
	private FAQView view;

	public FAQController(FAQView view, ProjectController parent) {
		this.view = view;
		parentController = parent;
	}

	@Override
	public int onInput(String input) {
		int move = -2;
		if (isBackPressed(input)) {
			return move;
		} else {
			parentController.addQuestion(input);
			return move;
		}
	}

	@Override
	public void onTakeControl() {
		view.update();
	}

	private boolean isBackPressed(String input) {
		int userChoice;
		try {
			userChoice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return userChoice == 0;
	}

}
