package com.anmertrix.module1.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Reader {
	
	protected String readUserNumbersLine() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String numbersLine = "";
		
		try {
			numbersLine = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numbersLine;
	}
}
