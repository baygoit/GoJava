package kickstarter.interfaces.readers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReader implements Reader {
	@Override
	public String getLine() throws IOException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		if (scanner.hasNextLine()) {
			return scanner.nextLine();
		}
		throw new IOException();
	}
}
