package goit.nz.kickstartermvc.controller;

import goit.nz.kickstartermvc.DispatcherListener;
import goit.nz.kickstartermvc.model.PaymentModel;
import goit.nz.kickstartermvc.view.PaymentView;

public class PaymentController implements DispatcherListener {
	private ProjectController parentController;
	private PaymentModel model;
	private PaymentView view;

	public PaymentController(PaymentModel model, PaymentView view,
			ProjectController parent) {
		this.model = model;
		this.view = view;
		parentController = parent;
	}

	@Override
	public int onInput(String input) {
		int move = 0;
		if (isBackPressed(input)) {
			model.clear();
			move = -1;
		} else if (model.getChosenRewardOptionIndex() == 0) {
			parseRewardOptionChoice(input);
		} else if (model.isCardHolderNameEmpty()) {
			parseCardHolderName(input);
		} else if (model.isCardNumberEmpty()) {
			parseCardNumber(input);
			if (model.isPaymentComplete()) {
				finalizePayment();
			}
		} else if (!model.isPaymentComplete()) {
			parseAmountPayed(input);
			if (model.isPaymentComplete()) {
				finalizePayment();
			}
		} else {
			showMessage(ControllerMessages.WRONG_USER_CHOICE_WARNING);
		}
		return move;
	}

	private void parseAmountPayed(String input) {
		int amountPayed = 0;
		try {
			amountPayed = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			showMessage(ControllerMessages.INPUT_NOT_INTEGER_WARNING);
		}
		if (amountPayed > 0) {
			model.setAmountPayed(amountPayed);
		} else {
			showMessage(ControllerMessages.INPUT_WRONG_PLEDGE_AMOUNT);
		}
	}

	private void parseCardNumber(String input) {
		if (model.isCardNumberValid(input)) {
			model.setCardNumber(input);
		} else {
			showMessage(ControllerMessages.INPUT_WRONG_CARD_NUMBER);
		}
	}

	private void parseCardHolderName(String input) {
		if (model.isCardHolderNameValid(input)) {
			model.setCardHolderName(input);
		} else {
			showMessage(ControllerMessages.INPUT_WRONG_CARDHOLDER_NAME);
		}
	}

	private void parseRewardOptionChoice(String input) {
		int userChoice = 0;
		try {
			userChoice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			showMessage(ControllerMessages.INPUT_NOT_INTEGER_WARNING);
		}
		if (userChoice > 0 && userChoice <= model.size()) {
			model.setChosenRewardOption(userChoice);
			if (userChoice < model.size()) {
				model.setAmountPayed(model.getRewardOptions()
						.get(userChoice - 1).getAmount());
			}
		} else {
			showMessage(ControllerMessages.WRONG_USER_CHOICE_WARNING);
		}
	}

	public void finalizePayment() {
		view.update(model);
		parentController.addPayment(model.getAmountPayed());
	}

	@Override
	public void onTakeControl() {
		updateModel();
		updateView();
	}

	private void updateModel() {
		model.update(parentController.getRewardOptions());
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

	private void updateView() {
		view.update(model);
	}

	private void showMessage(String message) {
		view.showMsg(message);
	}

}
