package goit.nz.kickstartermvc.view;

import goit.nz.kickstartermvc.dao.RewardOption;
import goit.nz.kickstartermvc.model.PaymentModel;
import goit.nz.kickstartermvc.output.Output;

import java.util.List;
import java.util.Map;

public class PaymentView {

	private Output output;

	public PaymentView(Output output) {
		this.output = output;
	}

	public void showMsg(String msg) {
		output.write("");
		output.write(msg);
	}

	public void update(PaymentModel model) {
		output.write("");
		if (model.getChosenRewardOptionIndex() == 0) {
			printRewardOption(model.getRewardOptions());
		} else {
			String prompt = prepareNextPrompt(model);
			printPayerInfo(model);
			showMsg(prompt);
		}
		printOption();
	}

	private void printPayerInfo(PaymentModel model) {
		for (Map.Entry<String, String> row : model.getPaymentData().entrySet()) {
			output.write(String.format("%s: %s", row.getKey(), row.getValue()));
		}
	}

	private String prepareNextPrompt(PaymentModel model) {
		String prompt = "";
		if (model.isCardHolderNameEmpty()) {
			prompt = "Enter cardholder name:";
		} else if (model.isCardNumberEmpty()) {
			prompt = "Enter card number:";
		} else if (model.getAmountPayed() == 0) {
			prompt = "Enter positive amount:";
		} else {
			prompt = "Thank you for your payment!";
		}
		return prompt;
	}

	private void printOption() {
		output.write("(0 - back)");
	}

	private void printRewardOption(List<RewardOption> rewardOptions) {
		output.write("You can choose such payment options:");
		output.write("-------------------");
		int index = 1;
		for (RewardOption rewardOption : rewardOptions) {
			output.write(String.format("[%d - %d : %s]", index++,
					rewardOption.getAmount(), rewardOption.getDescription()));
		}
		output.write(String.format("[%d - Any other amount]", index++));
	}

}
