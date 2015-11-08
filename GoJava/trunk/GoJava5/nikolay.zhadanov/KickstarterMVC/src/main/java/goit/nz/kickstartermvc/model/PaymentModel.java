package goit.nz.kickstartermvc.model;

import goit.nz.kickstartermvc.dao.RewardOption;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PaymentModel {

	private String cardHolderName;
	private String cardNumber;
	private int amountPayed;
	private List<RewardOption> rewardOptions;
	private int chosenRewardOptionIndex;

	public PaymentModel() {
		clear();
	}

	public boolean isCardHolderNameEmpty() {
		return cardHolderName.isEmpty();
	}

	public boolean isCardNumberEmpty() {
		return cardNumber.isEmpty();
	}

	public void setCardHolderName(String name) {
		cardHolderName = name;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setAmountPayed(int amount) {
		amountPayed = amount;
	}

	public void setChosenRewardOption(int index) {
		chosenRewardOptionIndex = index;
	}

	public int getChosenRewardOptionIndex() {
		return chosenRewardOptionIndex;
	}

	public int getAmountPayed() {
		return amountPayed;
	}

	public boolean isCardHolderNameValid(String name) {
		boolean result = true;
		for (char c : name.toCharArray()) {
			if (Character.isDigit(c)) {
				result = false;
				break;
			}
		}
		return result;
	}

	public boolean isCardNumberValid(String cardNumber) {
		boolean result = true;
		for (char c : cardNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				result = false;
				break;
			}
		}
		return result;
	}

	public Map<String, String> getPaymentData() {
		Map<String, String> paymentData = new LinkedHashMap<>();
		if (!isCardHolderNameEmpty()) {
			paymentData.put("Card Holder", cardHolderName);
		}
		if (!isCardNumberEmpty()) {
			paymentData.put("Card Number", cardNumber);
		}
		if (amountPayed > 0) {
			paymentData.put("Amount to pay", String.valueOf(amountPayed));
		}
		return paymentData;
	}

	public void clear() {
		cardHolderName = "";
		cardNumber = "";
		amountPayed = 0;
		chosenRewardOptionIndex = 0;
	}

	public void update(List<RewardOption> rewardOptions) {
		this.rewardOptions = new ArrayList<>();
		this.rewardOptions.addAll(rewardOptions);
	}

	public List<RewardOption> getRewardOptions() {
		return rewardOptions;
	}

	public int size() {
		return rewardOptions.size() + 1;
	}

	public boolean isPaymentComplete() {
		return !isCardHolderNameEmpty() && !isCardNumberEmpty()
				&& amountPayed > 0;
	}
}
