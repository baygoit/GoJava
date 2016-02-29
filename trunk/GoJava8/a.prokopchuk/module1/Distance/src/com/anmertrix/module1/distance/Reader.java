package com.anmertrix.module1.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

	protected String readUserNumbersLine() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String numbersLine = null;

		try {
			numbersLine = reader.readLine();
		} catch (IOException e) {
			numbersLine = "-1";
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Couldn't close the reader");
			}
		}

		return numbersLine;
	}
}
