package ua.com.gojava4.kickstarter.view;

import java.util.Scanner;

public class ConsoleReader implements Reader{
	
	public String readUserInput() {
		String result;
		Scanner scanner = new Scanner(System.in);
		try {
			result = scanner.next();
		}
		finally{
			scanner.close();
		}		
		
		return result;
	}

}
