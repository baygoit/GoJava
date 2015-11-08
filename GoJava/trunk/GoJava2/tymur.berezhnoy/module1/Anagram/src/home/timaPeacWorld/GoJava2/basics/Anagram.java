package home.timaPeacWorld.GoJava2.basics;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Anagram {
	
	public void startProcessing() {
		
		System.out.println("----- Enter a sentence and get reversed version of it. "
							+ "To exit enter sc -exit; -----");
		
		String line;
		while (!(line = enterSent()).equals("sc -exit;")) {
			System.out.println("The reversed sentence: " + getReversedSent(line));		
		}
		System.out.println("**** The App closed ****");
	}
	
	private String enterSent() {
		System.out.print("\nEnter a sentence: ");
		return new Scanner(System.in).nextLine();
	}	
	
	private String getReversedSent(String sentence) {
		String delimiters = " ,.!?@#$%^&*()-_=+<>/\';:[]{}|~`\""; // The symbols will not revers.
		StringTokenizer token = new StringTokenizer(sentence, delimiters, true);
		
		String resultString = "";
	
		while (token.hasMoreTokens()){
			resultString += new StringBuffer(token.nextToken()).reverse();
		}
		return resultString;
	}
	
	public static void main(String[] args) {
		Anagram anagramOb = new Anagram();
		anagramOb.startProcessing();
	}
}