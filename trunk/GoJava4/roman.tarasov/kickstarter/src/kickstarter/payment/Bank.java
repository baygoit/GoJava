package kickstarter.payment;

import java.util.HashMap;

public class Bank {
	private HashMap<String, Integer> bankAccount; // login , cardnumber
	private HashMap<Integer, Double> cardAccount; // cardnumber, money

	public Bank() {
		bankAccount = new HashMap<String, Integer>();
		cardAccount = new HashMap<Integer, Double>();
		bankAccount.put("bankir", (int) 777);
		cardAccount.put((int) 777, (double) 5000);
	}

	public double getBalance(String login, String number) throws BankException {
		if (login == null) {
			throw new BankException("login null");
		}
		if (login.equals("")) {
			throw new BankException("login empty");
		}
		if (number == null) {
			throw new BankException("cardnumber null");
		}
		if (number.equals("")) {
			throw new BankException("cardnumber empty");
		}
		int cardnumber = 0;
		try {
			cardnumber = Integer.parseInt(number);
		} catch (NumberFormatException | NullPointerException e) {
			throw new BankException("incorrect cardnumber");
		}
		if (cardAccount.get(cardnumber) == null) {
			throw new BankException("cardnumber not found");
		}
		return cardAccount.get(cardnumber);
	}

	public boolean getMoney(String login, String number, String money) throws BankException {
		if (money == null) {
			throw new BankException("money null");
		}
		if (money.equals("")) {
			throw new BankException("money empty");
		}

		if (login == null) {
			throw new BankException("login null");
		}
		if (login.equals("")) {
			throw new BankException("login empty");
		}
		if (number == null) {
			throw new BankException("cardnumber null");
		}
		if (number.equals("")) {
			throw new BankException("cardnumber empty");
		}
		int cardnumber = 0;
		try {
			cardnumber = Integer.parseInt(number);
		} catch (NumberFormatException | NullPointerException e) {
			throw new BankException("incorrect cardnumber");
		}
		Double getMoney = (double) 0;
		try {
			getMoney = Double.parseDouble(money);
			if (getMoney.isNaN()) {
				throw new NumberFormatException();
			}
			if (getMoney.isInfinite()) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException | NullPointerException e) {
			throw new BankException("incorrect money");
		}
		if (getMoney <= 0) {
			throw new BankException("incorrect money");
		}

		if (bankAccount.get(login) == null) {
			throw new BankException("account not found");
		}

		if (cardAccount.get(cardnumber) == null) {
			throw new BankException("account not found");
		}
		double moneyOnCard = cardAccount.get(cardnumber);

		if ((moneyOnCard - getMoney) < 0) {
			throw new BankException("balance error ");
		}
		moneyOnCard -= getMoney;
		cardAccount.put(cardnumber, moneyOnCard);
		return true;

	}
}
