package vadya_zakusylo.kickstarter.view.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput implements Input {

	@Override
	public int readInt() {
		try {
			return new Scanner(System.in).nextInt();
		} catch (InputMismatchException e) {
			// NOP, haven't inputted integer
			return -1;
		}
	}

	@Override
	public double readDouble() {
		try {
			return new Scanner(System.in).nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Input correct number (like is 10,0)");
			return readDouble();
		}
	}

	@Override
	public String readString() {
		String readLine = null;
		try {
			readLine = new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e) {
			// NOP
		}
		return readLine;
	}
}