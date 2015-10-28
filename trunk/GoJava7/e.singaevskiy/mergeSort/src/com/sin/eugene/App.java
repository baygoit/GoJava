package com.sin.eugene;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {

		Console console = new Console();
		console.readUserInput();
		//console.setUserInput("2 0 3 6 8 7 1 9 4 5");
		int[] numbers = console.parseUserInput();
		SortMerge.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		console.close();

	}
	
	

}
