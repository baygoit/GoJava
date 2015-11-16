package lonelynumber;

public class ApplicationRunner {
	
	public static void main(String[] args) {
		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleScanner consoleScanner = new ConsoleScanner();
		LonelyNumber lonelyNumber = new LonelyNumber();
		
		Application engine = new Application(consolePrinter, consoleScanner, lonelyNumber);
		engine.start();	
	}
}
