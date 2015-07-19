package goit.nz.kickstartermvc.controller;

import goit.nz.kickstartermvc.DispatcherListener;
import goit.nz.kickstartermvc.model.ProjectModel;
import goit.nz.kickstartermvc.view.ProjectView;

public class ProjectController implements DispatcherListener {

	private CategoryController parentController;
	private ProjectModel model;
	private ProjectView view;
	private int userChoice;

	public ProjectController(ProjectModel model, ProjectView view,
			CategoryController parent) {
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

	private void updateModel() {
		model.update(parentController.getChosenProject());
	}

	private void updateView() {
		view.printProject(model);
	}

	private void showMessage(String msg) {
		view.showMsg(msg);
	}

}
