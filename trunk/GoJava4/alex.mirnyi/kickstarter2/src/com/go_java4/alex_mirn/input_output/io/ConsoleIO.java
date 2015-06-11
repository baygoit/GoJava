package com.go_java4.alex_mirn.input_output.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO implements IO {
	
	@Override
	public void print(String string) {
		System.out.print(string);
	}

	@Override
	public void println(String string) {
		print(string + "\n");
	}
	
	@Override
	public int readline() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		return Integer.parseInt(reader.readLine());
	}
}
