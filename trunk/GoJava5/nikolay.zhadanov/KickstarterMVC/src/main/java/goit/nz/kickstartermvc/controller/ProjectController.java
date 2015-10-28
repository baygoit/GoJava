package goit.nz.kickstartermvc.controller;

import goit.nz.kickstartermvc.DispatcherListener;
import goit.nz.kickstartermvc.dao.RewardOption;
import goit.nz.kickstartermvc.model.ProjectModel;
import goit.nz.kickstartermvc.view.ProjectView;

import java.util.List;

public class ProjectController implements DispatcherListener {

	private CategoryController parentController;
	private ProjectModel model;
	private ProjectView view;
	private int userChoice;
	private String chosenCategoryName;
	private int chosenProjectIndex;

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
		} else if (userChoice == 1 || userChoice == 2) {
			move = userChoice;
		} else {
			showMessage(ControllerMessages.WRONG_USER_CHOICE_WARNING);
		}
		return move;
	}

	@Override
	public void onTakeControl() {
		chosenCategoryName = parentController.getProjectCategoryName();
		chosenProjectIndex = parentController.getProjectIndex();
		updateModel();
		updateView();
	}

	public void addPayment(int amount) {
		model.updatePledgedAmount(chosenCategoryName, chosenProjectIndex,
				amount);
	}

	public void addQuestion(String question) {
		model.addQuestion(chosenCategoryName, chosenProjectIndex, question);
	}
	
	public List<RewardOption> getRewardOptions() {
		return model.getRewardOptions();
	}

	private void updateModel() {
		model.update(chosenCategoryName, chosenProjectIndex);
	}

	private void updateView() {
		view.printProject(model);
	}

	private void showMessage(String msg) {
		view.showMsg(msg);
	}

}
