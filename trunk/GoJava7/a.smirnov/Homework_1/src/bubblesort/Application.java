package bubblesort;

import java.util.List;

public class Application {
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private BubblesSort bubblesSort = new BubblesSort();

	public void start() {
		List<Integer> inputedNumbers = null;
		String userInputString;
		
		boolean parseNotAcceptable = true;
		do {
			try {
				userInputString = consoleScanner.getUserInputString();
				inputedNumbers = consoleScanner.parseInt(userInputString);
				parseNotAcceptable = false;
			} catch (NumberFormatException e) {
				consolePrinter.print("You enetered forbidden symbol.");
			}
			
		} while (parseNotAcceptable);
		
		consolePrinter.print(inputedNumbers);
		int[] userInputedNumbers = consoleScanner.getNumbersInArray(inputedNumbers);
		int[] sortedNumbers = bubblesSort.sort(userInputedNumbers);
		consolePrinter.print(sortedNumbers);
	}
}
