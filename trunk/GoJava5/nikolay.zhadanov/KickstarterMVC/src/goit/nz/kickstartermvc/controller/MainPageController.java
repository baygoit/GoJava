package goit.nz.kickstartermvc.controller;

import goit.nz.kickstartermvc.DispatcherListener;
import goit.nz.kickstartermvc.model.MainPageModel;
import goit.nz.kickstartermvc.view.MainPageView;

public class MainPageController implements DispatcherListener {

	private MainPageModel model;
	private MainPageView view;
	private int userChoice;

	public MainPageController(MainPageModel model, MainPageView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public int onInput(String input) {
		int move = 0;
		try {
			userChoice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			showMessage("Input waits for integer numbers only - try one more time");
			return move;
		}
		if (userChoice == 0) {
			move = -1;
			showMessage("Kickstarter is off...");
		} else if (userChoice > 0 && userChoice <= model.size()) {
			move = 1;
		} else {
			showMessage("Wrong option number");
		}
		return move;
	}
	
	@Override
	public void onTakeControl(int move) {
		updateView();	
	}

	public String getChosenCategoryName() {
		return model.getCategory(userChoice - 1).getName();
	}

	public void onAppStart() {
		view.printHelloMsg(model);
		updateView();
	}
	
	private void updateView() {
		view.printCategories(model);
	}

	private void showMessage(String msg) {
		view.showMsg(msg);
	}
}
