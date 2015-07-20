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
		} else if (model.isCardHolderNameEmpty()) {
			if (model.isCardHolderNameValid(input)) {
				model.setCardHolderName(input);
			} else {
				showMessage(ControllerMessages.INPUT_WRONG_CARDHOLDER_NAME);
			}
		} else if (model.isCardNumberEmpty()) {
			if (model.isCardNumberValid(input)) {
				model.setCardNumber(input);
			} else {
				showMessage(ControllerMessages.INPUT_WRONG_CARD_NUMBER);
			}
		} else {
			int amountPayed;
			try {
				amountPayed = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				showMessage(ControllerMessages.INPUT_NOT_INTEGER_WARNING);
				return move;
			}
			if (amountPayed > 0) {
				model.setAmountPayed(amountPayed);
				parentController.addPayment(model.getAmountPayed());
				model.clear();
				move = -1;
			} else {
				showMessage(ControllerMessages.INPUT_WRONG_PLEDGE_AMOUNT);
			}
		}
		return move;
	}

	@Override
	public void onTakeControl() {
		updateView();
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
		String prompt;
		if (model.isCardHolderNameEmpty()) {
			prompt = "Enter cardholder name:";
		} else if (model.isCardNumberEmpty()) {
			prompt = "Enter card number:";
		} else {
			prompt = "Enter positive amount:";
		}
		view.update(model.getPaymentData(), prompt);
	}

	private void showMessage(String message) {
		view.showMsg(message);
	}

}
