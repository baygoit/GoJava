package com.go_java4.alex_mirn.view.io;

import java.io.IOException;

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
//			String in = io.readline();
//			int inInt = Integer.parseInt(in);
			int inInt = io.readline();
			return inInt;
		} catch (NumberFormatException e) {
			io.println("You entered unacceptable character. "
					+ "Make a choise and press enter");
			return inputAccept();
		}
	}
}
