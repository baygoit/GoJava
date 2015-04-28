package go_java_4.vadya_zakusylo.java_basics;

import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		String inputText = initList();
		String[] arrayText = createArray(inputText);
		String outputText = Permutation(arrayText);
		System.out.println(outputText);
	}

	private static String initList() {
		try (Scanner consolText = new Scanner(System.in)) {
			System.out.println("Enter the text.");
			return consolText.nextLine();
		}
	}

	private static String[] createArray(String inputText) {
		String array = "";
		String[] arrayText;
		do {
			int indexOfSeparator = inputText.indexOf(" ");
			array += inputText.substring(0, indexOfSeparator + 1);
			inputText = inputText.substring(indexOfSeparator + 1,
					inputText.length());
		} while (inputText.contains(" "));
		array += inputText;
		arrayText = array.split(" ");
		return arrayText;
	}

	private static String Permutation(String[] arrayText) {
		String outputText = "";
		for (String text : arrayText) {
			StringBuffer sb = new StringBuffer(text);
			sb.reverse();
			outputText += sb + " ";
		}
		return outputText;
	}
}
