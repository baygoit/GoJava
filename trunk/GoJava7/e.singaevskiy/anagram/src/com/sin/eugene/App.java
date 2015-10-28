package com.sin.eugene;

public class App {

	public static void main(String[] args) {

		Console console = new Console();
		System.out.println(Anagram.reverse(console.getUserInput()));
		console.close();
		
	}

}
