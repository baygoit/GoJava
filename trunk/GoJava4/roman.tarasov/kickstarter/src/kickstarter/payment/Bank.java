package kickstarter.payment;

import java.util.HashMap;

public class Bank {
	HashMap<String, Integer> bankAccount; // login , cardnumber
	HashMap<Integer, Double> cardAccount; // cardnumber, money

	public Bank() {
		bankAccount = new HashMap<String, Integer>();
		cardAccount = new HashMap<Integer, Double>();
		bankAccount.put("bankir", (int) 777);
		cardAccount.put((int) 777, (double) 5000);
	}

	public double getBalance(String login, String number) {
		if (login == null) {
			return -1;
		}
		if (login.equals("")) {
			return -1;
		}
		if (number == null) {
			return -1;
		}
		if (number.equals("")) {
			return -1;
		}
		int cardnumber = 0;
		try {
			cardnumber = Integer.parseInt(number);
		} catch (NumberFormatException | NullPointerException e) {
			return -1;
		}
		if (cardAccount.get(cardnumber) == null) {
			return -1;
		}
		return cardAccount.get(cardnumber);
	}

	public boolean getMoney(String login, String number, String money) {
		if (money == null) {
			return false;
		}
		if (money.equals("")) {
			return false;
		}
		if (login == null) {
			return false;
		}
		if (login.equals("")) {
			return false;
		}
		if (number == null) {
			return false;
		}
		if (number.equals("")) {
			return false;
		}
		int cardnumber = 0;
		try {
			cardnumber = Integer.parseInt(number);
		} catch (NumberFormatException | NullPointerException e) {
			return false;
		}
		double getMoney = 0;
		try {
			getMoney = Double.parseDouble(money);
		} catch (NumberFormatException | NullPointerException e) {
			return false;
		}
		if (getMoney <= 0) {
			return false;
		}

		if (bankAccount.get(login) == null) {
			return false;
		}

		if (cardAccount.get(cardnumber) == null) {
			return false;
		}
		double moneyOnCard = cardAccount.get(cardnumber);

		if ((moneyOnCard - getMoney) < 0) {
			return false;
		}
		moneyOnCard -= getMoney;
		cardAccount.put(cardnumber, moneyOnCard);
		return true;

	}
}
