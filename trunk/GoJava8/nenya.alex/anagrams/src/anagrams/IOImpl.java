package anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOImpl implements IO{
	
	public String read() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}

	@Override
	public void write(String str) {
		System.out.println(str);
	}
}
