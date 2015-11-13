package mergesort;

import java.util.List;

public class Application {
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private MergeSort mergeSort = new MergeSort();

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
		int[] arrayOfNumbers = consoleScanner.getNumbersInArray(inputedNumbers);
		int[] sortedArrayOfNumbers = mergeSort.sort(arrayOfNumbers);
		
		consolePrinter.print(sortedArrayOfNumbers);
	}
}
