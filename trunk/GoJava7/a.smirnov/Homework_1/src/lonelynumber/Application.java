package lonelynumber;

import java.util.List;

public class Application {
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private LonelyNumber lonelyNumber = new LonelyNumber();

	public Application(ConsolePrinter consolePrinter, ConsoleScanner consoleScanner, LonelyNumber lonelyNumber) {
		this.consolePrinter = consolePrinter;
		this.consoleScanner = consoleScanner;
		this.lonelyNumber = lonelyNumber;
	}

	public void start() {
		List<Integer> inputedNumbers = null;
		String userInputString;
		boolean flag = true;
		do {
			try {
				userInputString = consoleScanner.getUserInputString();
				inputedNumbers = consoleScanner.parseInt(userInputString);
				flag = false;
			} catch (NumberFormatException e) {
				consolePrinter.print("You enetered forbidden symbol.");
			}
			
		} while (flag);
		
		consolePrinter.print(inputedNumbers);
		int[] userNumbers = consoleScanner.getNumbersInArray(inputedNumbers);
		List<Integer> result = lonelyNumber.getLonelyNumber(userNumbers, consolePrinter);
		
		consolePrinter.printLonelyNumber(result);
		consoleScanner.shutDown();
	}
}
