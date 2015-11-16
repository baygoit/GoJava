package ua.com.goit.gojava7.lonely;

public class App {
	
	private static int TARGET_COUNT = 3;
	
	public static void main(String[] args) {

		Console console = new Console();
		console.readUserInput();
		int[] numbers = console.parseUserInput();
		System.out.printf("Lonely number: %d", LonelyNumber.findLonely(numbers, TARGET_COUNT));
		console.close();
		
	}

}
