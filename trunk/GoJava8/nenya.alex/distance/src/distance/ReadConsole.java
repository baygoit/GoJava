package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {
	
	public String read() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		return reader.readLine();
	}
}
