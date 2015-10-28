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
			showMessage(ControllerMessages.INPUT_NOT_INTEGER_WARNING);
			return move;
		}
		if (userChoice == 0) {
			move = -1;
			showMessage(ControllerMessages.EXIT_MESSAGE);
		} else if (userChoice > 0 && userChoice <= model.size()) {
			move = 1;
		} else {
			showMessage(ControllerMessages.WRONG_USER_CHOICE_WARNING);
		}
		return move;
	}
	
	@Override
	public void onTakeControl() {
		updateModel();
		updateView();	
	}

	public String getChosenCategoryName() {
		return model.getCategory(userChoice - 1).getName();
	}

	public void onAppStart() {
		view.printHelloMsg(model);
		onTakeControl();
	}
	
	private void updateView() {
		view.printCategories(model);
	}
	
	private void updateModel() {
		model.update();
	}

	private void showMessage(String msg) {
		view.showMsg(msg);
	}
}
