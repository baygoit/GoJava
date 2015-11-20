package ua.com.goit.gojava7.kickstarter.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.NumberFormatException;

public class ConsoleScanner {

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public int getInt(int start, int end) {
		int number;		
		while (true) {
			while (true) {							
				try {
				number = Integer.parseInt(bufferedReader.readLine());
				} catch (NumberFormatException | IOException e) {
					System.out.println("You should type a NUMBER from " + start + " to " + end + ": ");					
					continue;
				}
				break;
			}			
			if ((number < start | number > end) & number != 0) {
				System.out.println("You should type a number FROM " + start + " TO " + end + ": ");
				continue;
			} else {
				return number;
			}
		}
	}

	public String getOption() {
		String text = null;
		while (true) {
			System.out.println("\nType:" + "\nb: to back this project" + "\na: to ask a questions"
					+ "\n0: to choose another project");
			try {
				text = bufferedReader.readLine();
			} catch (IOException e) {
				continue;
			}
			if (text.equals("0"))
				return "0";
			else if (text.equals("b"))
				return "b";
			else if (text.equals("a"))
				return "a";
		}
	}

	public String getString() {
		String text = null;
		try {
			text = bufferedReader.readLine();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return text;
	}	

	public void close() {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
