package com.gojava2.anagram;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Anagram {
	
	private String delimiters;
	
	public Anagram() {
		delimiters = " ,.!?@#$%^&*()-_=+<>/\';:[]{}|~`\"";
	}
	
	public String getDelimiters() {
		return delimiters;
	}
	
	public void setNewDelimiters(String delimiters) {
		this.delimiters = delimiters;
	}
		
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
	
	public String getReversedSent(String sentence) {
		String resultString = "";
		if(sentence == null) {
			return resultString;
		} else {
		StringTokenizer token = new StringTokenizer(sentence, getDelimiters(), true);
		while (token.hasMoreTokens()){
			resultString += new StringBuffer(token.nextToken()).reverse();
		}
		return resultString;
		}
	}
	
	public static void main(String[] args) {
		Anagram anagramOb = new Anagram();
		anagramOb.startProcessing();
	}
}