package ua.com.goit.gojava.kickstarter.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputReader implements Reader{
    
    private final static int DEFAULT_INPUT = -1;
    
    public int readUserInput() {
	int result = DEFAULT_INPUT;
	try {
	    result = new Scanner(System.in).nextInt();
	} catch (InputMismatchException e) {
	    e.printStackTrace();
	}
	System.out.println();
	return (result >= DEFAULT_INPUT) ? result : DEFAULT_INPUT;
    }
}
