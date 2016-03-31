package com.anmertrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO implements IO {

	public String readConsole() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String result = null;
		try {
			result = reader.readLine();
		} catch (IOException e) {
			result = "-1";
		}
		return result;
	}

	public void print(String message) {
		System.out.print(message);
	}

	public void println(String message) {
		print(message + "\n");
	}

}
