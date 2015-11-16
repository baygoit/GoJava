package distance;

import java.util.List;

public class Application {
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private Distance distance = new Distance();
	
	public void start() {
		List<Integer> inputedNumbers = null;
		String userInputString;
		boolean inputNotAcceptable = true;
		do {
			try {
				userInputString = consoleScanner.getUserInputString();
				inputedNumbers = consoleScanner.parseInt(userInputString);
				inputNotAcceptable = false;
			} catch (NumberFormatException e) {
				consolePrinter.print("You enetered forbidden symbol.");
			}
			
		} while (inputNotAcceptable);
		
		consolePrinter.print(inputedNumbers);
		String result = distance.getDistances(inputedNumbers);
		consolePrinter.print(result);
		consoleScanner.shutDown();
	}
}
