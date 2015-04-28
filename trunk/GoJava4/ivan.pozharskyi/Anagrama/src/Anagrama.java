import java.util.Scanner;
import java.util.Stack;

public class Anagrama {

	public static void main(String[] args) {

		System.out.println("Enter words:");
		String enteredData = readFromConsole();

		String[] result = makeAnagrama(enteredData.split(" "));                                    
		printResult(result);
	}

	private static String readFromConsole() {

		Scanner scanner;
		scanner = new Scanner(System.in);
		String enteredData = scanner.nextLine();
		scanner.close();

		return enteredData;
	}

	private static void printResult(String[] result) {
		
		System.out.println("Result:");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static String[] makeAnagrama(String[] enteredData) {
		String[] result = enteredData;
		for (int i = 0; i < enteredData.length; i++) {

			char[] words = enteredData[i].toCharArray();
			char[] reverseWord = reversingWord(words);
			result[i] = String.valueOf(reverseWord);

		}
		return result;

	}

	private static char[] reversingWord(char[] words) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < words.length; i++) {
			stack.push(words[i]);
		}

		char[] reverseWord = words;
		for (int i = 0; i < words.length; i++) {
			reverseWord[i] = (char) stack.pop();

		}

		return reverseWord;
	}
}
