package com.gojava2.kickstarter.view;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput implements InPut {
	
	@Override
	public int read() throws InputMismatchException {
		return new Scanner(System.in).nextInt();
	}
}