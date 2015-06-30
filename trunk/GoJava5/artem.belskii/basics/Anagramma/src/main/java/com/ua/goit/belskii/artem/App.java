package com.ua.goit.belskii.artem;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Input consoleIn = new Input();
		consoleIn.setString();
		Convert anagramma = new Convert();
		System.out.println(anagramma.convert(consoleIn.getString()));
	}
}
