package anagram;

public class Application {
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private Anagram reverse = new Anagram();
	
	public void start() {
		String userInputString = consoleScanner.getUserInputString(consolePrinter);
		String reversedString = reverse.reverseString(userInputString);
		consolePrinter.printInputedString(userInputString);
		consolePrinter.printReversedString(reversedString);
	}
}
