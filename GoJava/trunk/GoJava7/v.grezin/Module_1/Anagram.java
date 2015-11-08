package com.gmail.grezin.v;
/*
* Task 3:
* Output string anagram.
*/
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String text = "";
		String anagram = "";
		char[] charachters;

		System.out.println("Please enter your string");
		text = sc.nextLine();
		charachters = new char[text.length()];
		charachters = text.toCharArray();

		for (int i = charachters.length - 1; i >= 0; i--) {
			anagram += charachters[i];
		}
		System.out.println("Source: " + text);
		System.out.println("Anagram: " + anagram);
		sc.close();
	}
}
