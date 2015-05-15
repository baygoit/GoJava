package UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

import datasource.DataSource;
import kickstarter.Kickstarter;

public class ConsoleIn implements Input {
	private static final int CATEGORY_LEVEL = 0;
	private static final int PROJECT_LEVEL = 1;
	private DataSource dataSource = Kickstarter.getDataSource();

	@Override
	public void getFromUser(int[] menuPosition) {
		System.out.println("Make a choise:");
		int userChoise = getUserChise();
		
		if (menuPosition[PROJECT_LEVEL] != 0) {
			processProjectLevel(menuPosition, userChoise);
		} else if (menuPosition[PROJECT_LEVEL] == 0 && menuPosition[CATEGORY_LEVEL] != 0) {
			processCategoryLevel(menuPosition, userChoise);	
		} else {
			processMainLevel(menuPosition, userChoise);
		}		
	}


	private void processMainLevel(int[] menuPosition, int userChoise) {
		if (dataSource.checkIfCategoryExist(userChoise)) {
			menuPosition[CATEGORY_LEVEL] = userChoise;
		} else {
			askForChoiseAgain(menuPosition);
		}
	}


	private void processCategoryLevel(int[] menuPosition, int userChoise) {
		if (userChoise == 0) {
			menuPosition[CATEGORY_LEVEL] = 0;
		} else {
			if (dataSource.checkIfProjectExist(menuPosition[CATEGORY_LEVEL], userChoise)) {
				menuPosition[PROJECT_LEVEL] = userChoise;
			} else {
				askForChoiseAgain(menuPosition);
			}
		}
	}


	private void processProjectLevel(int[] menuPosition, int userChoise) {
		if (userChoise == 0) {
			menuPosition[PROJECT_LEVEL] = 0;
		} else {
			askForChoiseAgain(menuPosition);
		}
	}


	private void askForChoiseAgain(int[] menuPosition) {
		System.out.println("There no such variant. Try Again.");
		getFromUser(menuPosition);
	}


	private int getUserChise() {
		Scanner scaner = new Scanner(System.in);
		try {
			int result = scaner.nextInt();
			return result;
		} catch (InputMismatchException e) {
			System.err.println("You entered not a number. Try Again.");
			return getUserChise();
		}

	}

}
