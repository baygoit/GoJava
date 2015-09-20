package kickstarter.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader implements Reader {

	public int readUserInput() {
		int result = 0;
		try {
			result = new Scanner(System.in).nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		System.out.println();
		return result;
	}

	@Override
	public String readline() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}
}
