package com.anmertrix.module1.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO implements IO {
	
	@Override
	public String readConsole() {
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		String result = null;
		
		try {
			result = reader.readLine();
		} catch (IOException e) {
			result = "-1";
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Couldn't close the reader");
			}
		}
		return result;
	}

	@Override
	public void print(String message) {
		System.out.print(message);
	}
}
