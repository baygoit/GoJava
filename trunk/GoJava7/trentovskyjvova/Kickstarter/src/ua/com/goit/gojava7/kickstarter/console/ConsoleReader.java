package ua.com.goit.gojava7.kickstarter.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int read() throws IOException {
		int result;
		try {
			result = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			result = -1;
		}
		return result;
	}
	
	public void close() throws IOException{
		br.close();
	}

}
