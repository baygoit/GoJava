package anagram;

import java.util.Scanner;

public class Anagram {

    private String inputText;
    private String result;

    public static void main(String[] args) {

	Anagram anagram = new Anagram();
	anagram.readInput();
	anagram.makeAnagramFrom(anagram.getInput());
	anagram.printResult();

    }

    public void readInput() {
	System.out.print("Enter some text: ");
	Scanner scan = new Scanner(System.in);
	inputText = scan.nextLine();
	scan.close();
    }

    public String getInput() {
	return inputText;
    }

    public void makeAnagramFrom(String text) {
	StringBuilder tempString = new StringBuilder();
	StringBuilder newString = new StringBuilder();

	for (int index = 0; index < text.length(); index++) {
	    if (text.charAt(index) != ' ') {
		tempString.append(text.charAt(index));
	    } else {
		newString.append(tempString.reverse()).append(" ");
		tempString.delete(0, tempString.length());
	    }
	}

	newString.append(tempString.reverse());
	result = newString.toString();

    }

    public String printResult() {
	System.out.println(result);
	System.out.println("=====================================");
	return result;
    }

}
