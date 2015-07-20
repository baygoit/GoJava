package goit.nz.kickstartermvc.controller;

import goit.nz.kickstartermvc.DispatcherListener;
import goit.nz.kickstartermvc.model.CategoryModel;
import goit.nz.kickstartermvc.view.CategoryView;

public class CategoryController implements DispatcherListener {

	private MainPageController parentController;
	private CategoryModel model;
	private CategoryView view;
	private int userChoice;
	private String chosenCategoryName;

	public CategoryController(CategoryModel model, CategoryView view,
			MainPageController parent) {
		this.model = model;
		this.view = view;
		parentController = parent;
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
		} else if (userChoice > 0 && userChoice <= model.size()) {
			move = 1;
		} else {
			showMessage(ControllerMessages.WRONG_USER_CHOICE_WARNING);
		}
		return move;
	}

	@Override
	public void onTakeControl() {
		chosenCategoryName = parentController.getChosenCategoryName();
		updateModel();
		updateView();
	}

	public int getProjectIndex() {
		return userChoice;
	}
	
	public String getProjectCategoryName() {
		return chosenCategoryName;
	}

	private void updateModel() {
		model.update(chosenCategoryName);
	}

	private void updateView() {
		view.printProjects(model, chosenCategoryName);
	}

	private void showMessage(String msg) {
		view.showMsg(msg);
	}

}
