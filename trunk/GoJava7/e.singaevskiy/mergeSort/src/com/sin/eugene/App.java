// OLEG What is http:://sin.com? A porn side advertisement? Really?
package com.sin.eugene;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {

		Console console = new Console();
		// OLEG it looks like we have strong dependency between readUserInput() and parseUserInput(). We should remember about it and share this knowladge with other developers, or change something. May be merge both methods into one? Or return String in readUserInput()? I don't know
		// OLEG UserInput. But we wait for array of numbers... I should be in context of the task to understand it.
		console.readUserInput();
		//console.setUserInput("2 0 3 6 8 7 1 9 4 5");
		int[] numbers = console.parseUserInput();
		// OLEG I have static methods... But ok, now it's not relevant.
		SortMerge.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		// OLEG what is we had any exception before? console can be not closed...
		console.close();

	}
	
	

}
