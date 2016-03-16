package ua.nenya.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.nenya.util.IO;


public class ConsoleIOImpl implements IO {

	@Override
	public void writeln(String str) {
		System.out.println(str);
	}

	@Override
	public void write(String str) {
		System.out.print(str);
	}

	@Override
	public String readConsole() {
		String result = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			result = reader.readLine();
		} catch (IOException e) {
			writeln("Wrong entering!");
		}
		return result;
	}

}
