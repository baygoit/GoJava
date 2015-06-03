package com.go_java4.alex_mirn.input_output;

import java.io.IOException;

import com.go_java4.alex_mirn.input_output.io.IO;

public class InputData {
	IO io;

	public InputData(IO io) {
		this.io = io;
	}

	public int inputData(int size) throws IOException {
		while (true) {
			int inputData = inputAccept();
			if (inputData > size || inputData < 0) {
				io.println("You entered invalid number. please try again");
			} else {
				return inputData;
			}
		}
	}

	public int inputAccept() throws IOException {
		try {
			String in = io.readline();
			int inInt = Integer.parseInt(in);
			return inInt;
		} catch (NumberFormatException e) {
			io.println("You entered unacceptable character. "
					+ "Make a choise and press enter");
			return inputAccept();
		}
	}
}
