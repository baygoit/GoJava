package ua.com.goit.gojava7.kickstarter;

import java.util.Scanner;

import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteHolder;



public class Kickstarter {
	static int exitSign = 0;
	static Scanner sc = new Scanner(System.in);
	static PaymentSystem ps = new PaymentSystem();
	
	public static void main(String[] args) {
	
		QuoteHolder qh = new QuoteHolder();
		Printer.print(qh.getQuote());
		Printer.prints(CategoryStorage.getCategories());
		category();

	}

	public static void category() {

		Printer.CategoryInform();
		int categoryNumber = UserInputReader.read();
		if (categoryNumber == exitSign) {
			Printer.left();
		} else {
			Printer.chosenCategoryInform(categoryNumber);
			Printer.categoryInform(categoryNumber);
			Printer.exitInform();
			project(categoryNumber);
		}
	}

	public static void project(int categoryNumber) {
		Printer.ProjectInform();
		while (true) {
			int projectNumber = UserInputReader.read();
			if (projectNumber == exitSign) {
				category();

			} else {
				Printer.chosenProjectInform(projectNumber, categoryNumber);
				Printer.projectInform(projectNumber, categoryNumber);
				Printer.toDoPosobilities();
				int payment = UserInputReader.read();
				int makePayment = 200;
				if (payment == makePayment) {
					ps.makePayment(projectNumber, categoryNumber);

				} else {
					project(categoryNumber);
					Printer.ProjectInform();
					Printer.exitInform();
				}
			}

		}

	}

	
}
