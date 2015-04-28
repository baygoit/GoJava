import java.util.Scanner;
import java.util.Stack;

public class Anagrama {
	private String enteredData;
	public Anagrama(String enteredData){
		this.enteredData = enteredData;
	}
	public Anagrama(){
		
	}

	public static void main(String[] args) {

		System.out.println("Enter words:");
		Anagrama anagrama = new Anagrama();
		anagrama.enteredData = anagrama.readFromConsole();
		

		String[] words = anagrama.enteredData.split(" ");
		String[] result = anagrama.makeAnagrama(words);                                    
		anagrama.printResult(result);
	}

	private String readFromConsole() {

		Scanner scanner;
		scanner = new Scanner(System.in);
		String enteredData = scanner.nextLine();
		scanner.close();

		return enteredData;
	}

	private void printResult(String[] result) {
		
		System.out.println("Result:");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private String[] makeAnagrama(String[] enteredData) {
		String[] result = enteredData;
		for (int i = 0; i < enteredData.length; i++) {

			char[] words = enteredData[i].toCharArray();
			char[] reverseWord = reversingWord(words);
			result[i] = String.valueOf(reverseWord);

		}
		return result;

	}

	private char[] reversingWord(char[] words) {

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
