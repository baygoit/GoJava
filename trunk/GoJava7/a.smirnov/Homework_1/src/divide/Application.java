package divide;

public class Application {
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private Divide divideProcess = new Divide();

	public void start() {
		int firstNumber = 1;
		int secondNumber = 1;
		
		boolean parseNotAcceptable = true;
		do {
			try {
				String firstInputedString = consoleScanner.getFirstUserNumber();
				String secondIputedString = consoleScanner.getSecondUserNumber();
				
				firstNumber = consoleScanner.parseInt(firstInputedString);
				secondNumber = consoleScanner.parseInt(secondIputedString);
				parseNotAcceptable = false;
			} catch (NumberFormatException e) {
				consolePrinter.print("You enetered forbidden symbol.");
			}
			
		} while (parseNotAcceptable);
		
		StringBuilder userInputedNumbers = new StringBuilder();
		userInputedNumbers.
			append(firstNumber).
			append(" / ").
			append(secondNumber).
			append("\n").
			append("--------");
		
		consolePrinter.print(userInputedNumbers.toString());
		consolePrinter.print(divideProcess.divide(firstNumber, secondNumber));
	}
}
