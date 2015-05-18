package go_java_4.vadya_zakusylo.java_basics;

import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		anagram.go();
	}

	void go() {
		String stringLine = initStringLine().trim();
		String[] arrayString = createStringArray(stringLine);
		System.out.println(permute(arrayString));
	}

	String initStringLine() {
		try (Scanner consolText = new Scanner(System.in)) {
			System.out.println("Enter the text.");
			return consolText.nextLine();
		}
	}

	String[] createStringArray(String inputText) {
		String array = "";
		do {
			int indexOfSeparator = inputText.indexOf(" ");
			array += inputText.substring(0, indexOfSeparator + 1);
			inputText = inputText.substring(indexOfSeparator + 1, inputText.length()).trim();
		} while (inputText.contains(" "));
		array += inputText;
		return array.split(" ");
	}

	String permute(String[] arrayText) {
		String outputText = "";
		for (int index = 0; index < arrayText.length; index++) {
			StringBuffer sb = new StringBuffer(arrayText[index]);
			sb.reverse();
			if (index == arrayText.length - 1) {
				outputText += sb;
			} else {
				outputText += sb + " ";
			}
		}
		return outputText;
	}
}
