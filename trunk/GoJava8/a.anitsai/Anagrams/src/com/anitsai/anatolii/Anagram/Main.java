package com.anitsai.anatolii.Anagram;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Reader reader = new Reader();
		Anagram anagram = new Anagram();
		try {
			System.out.println("Enter string: ");
			String consoleString = reader.readConsoleString();
			System.out.println(anagram.getAnagrams(consoleString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
