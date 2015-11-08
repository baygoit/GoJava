package com.sin.eugene;

public class App {

	public static void main(String[] args) {

		Console console = new Console();
		console.readUserInput();
		Distance.printDistance(console.parseUserInput(), 2);
		console.close();
		
	}

}
