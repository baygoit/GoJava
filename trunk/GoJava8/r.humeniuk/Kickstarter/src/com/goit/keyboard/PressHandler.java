package com.goit.keyboard;

import java.util.Scanner;

import com.goit.io.PageReaderImpl;
import com.goit.logic.CardCheker;
import com.goit.logic.CreditCard;
import com.goit.logic.EmailChecker;
import com.goit.logic.User;

public class PressHandler {
	PageReaderImpl consoleOutpuImpl;
	Scanner scanner;
	CreditCard card;
	User user;
	EmailChecker emailChecker;
	CardCheker cardCheker;

	private String menuFilePath;
	private String quoteFilePath;

	public PressHandler(String menuFilePath, String quoteFilePath) {
		this.menuFilePath = menuFilePath;
		this.quoteFilePath = quoteFilePath;
		user = new User();
		card = new CreditCard();
		emailChecker = new EmailChecker();
		cardCheker = new CardCheker();
		consoleOutpuImpl = new PageReaderImpl();

	}

	public void openMenu() {
		consoleOutpuImpl.showMenu(menuFilePath, quoteFilePath);
	}

	int numberCategory;

	public void chooseCategory() {
		scanner = new Scanner(System.in);
		try {
			if (scanner.hasNextInt()) {
				if ((numberCategory = scanner.nextInt()) != 0) {
					consoleOutpuImpl.showCategory(numberCategory);
					chooseProject();
				} else {
					System.out.println("Good Bay");
				}
			} else {
				System.out.println("You can not enter characters!");
				chooseCategory();
			}
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("There is no such category!");
			chooseCategory();
		} finally {
			scanner.close();
		}
	}

	int numberProject;

	public void chooseProject() {
		scanner = new Scanner(System.in);
		try {
			if (scanner.hasNextInt()) {
				if ((numberProject = scanner.nextInt()) != 0) {
					consoleOutpuImpl.showProject(numberProject);
					shareManey();
				} else {
					//openMenu();
					//chooseCategory();
					consoleOutpuImpl.showCategory(numberCategory);
					chooseProject();
				}
			} else {
				System.out.println("You can not enter characters!");
				chooseProject();
			}
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("There is no such project!");
			chooseProject();
		}
	}

	// --------------------------
	public void shareManey() throws NumberFormatException, IndexOutOfBoundsException {
		scanner = new Scanner(System.in);
		int key;
		try {
			if (scanner.hasNextInt()) {
				if (((key = scanner.nextInt()) != 0) && (key == 1)) {
					consoleOutpuImpl.showProject(key);
					System.out.println("Enter your name:");
					enterUsername();
					System.out.println("Enter your email");
					enterEmail();
					System.out.println("How much money you donate?");
					enterInvestmentAmount();
					System.out.println("Enter card number (16 digits)");
					enterCardNumber();
					System.out.println("Enter CVV-code, example: 123");
					enterCVVCode();
					System.out.println("Ener valid true (month/year)");
					enterValidTrue();
				} else {
					openMenu();
					chooseCategory();
					chooseProject();
				}
			} else {
				System.out.println("You can not enter characters!");
				chooseProject();
			}
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("There is no such project!");
			chooseProject();
		}
	}

	// --------------------------
	public void sendQuestion() {

	}

	private void enterUsername() {
		scanner = new Scanner(System.in);
		String name = scanner.next();
		user.setName(name);
		card.setNameHolder(name);
	}

	private void enterEmail() {
		scanner = new Scanner(System.in);
		String email = scanner.next();
		if (emailChecker.validate(email)) {
			user.setEmail(email);
		} else {
			System.out.println("invalid email");
			enterEmail();
		}

	}

	private void enterCardNumber() throws NumberFormatException {
		scanner = new Scanner(System.in);
		String number = scanner.next();
		if (cardCheker.chekCardNumber(number)) {
			card.setNumberCard(number);
		} else {
			System.out.println("invalid card number");
			enterCardNumber();
		}

	}

	private void enterCVVCode() {
		scanner = new Scanner(System.in);
		int cvv;
		if (scanner.hasNextInt()) {
			cvv = scanner.nextInt();
			if (cardCheker.chekCardCVV(cvv)) {
				card.setCvvCode(cvv);
			} else {
				System.out.println("invalid CVV code, example: 123");
				enterCVVCode();
			}
		} else {
			System.out.println("You can not enter characters!");
			enterCVVCode();
		}
	}

	private void enterValidTrue() throws IndexOutOfBoundsException {
		scanner = new Scanner(System.in);
		String date = scanner.next();
		if (cardCheker.chekValidTrue(date)) {
			card.setValidThru(date);
		} else {
			System.out.println("invalid date, example: 05/17 (monyh/year)");
			enterValidTrue();
		}
	}

	private void enterInvestmentAmount() {
		scanner = new Scanner(System.in);
		int money;

		if (scanner.hasNextInt()) {
			if ((money = scanner.nextInt()) != 0) {
				user.setInvestmentAmount(money);
			} else {
				System.out.println("invalid value");
				enterInvestmentAmount();
			}
		} else {
			System.out.println("invalid value");
			enterInvestmentAmount();
		}
	}

}
