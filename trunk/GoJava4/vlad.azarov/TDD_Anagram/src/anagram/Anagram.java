package anagram;

import java.util.Scanner;

public class Anagram {

    private String inputText;
    private String result;

    public void readInput() {
	System.out.print("Enter some text: ");
	Scanner scan = new Scanner(System.in);
	inputText = scan.nextLine();
    }

    public String getInput() {
	return inputText;
    }

    public void makeAnagramFrom(String text) {
	StringBuilder tempString =  new StringBuilder();
	StringBuilder newString = new StringBuilder();

	for (int index = 0; index < text.length(); index++) {
	    tempString.append(text.charAt(index));
	}
	
	newString.append(tempString.reverse());
	result = newString.toString();

    }
    
    public void printResult() {
	System.out.println(result);
    }

}
