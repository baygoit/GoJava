package anagram;

public class ConsolePrinter {
	
	public void printReversedString(String reversedString) {
		StringBuilder result = new StringBuilder();
		
		result.
			append("Reversed string: ").
			append(reversedString);
		System.out.println(result.toString());
	}
	
	public void printInputedString(String inputString) {
		StringBuilder result = new StringBuilder();
		
		result.
			append("User's inputed string : ").
			append(inputString);
		System.out.println(result.toString());
	}
	
	public void print(String str) {
		System.out.println(str);
	}
}
