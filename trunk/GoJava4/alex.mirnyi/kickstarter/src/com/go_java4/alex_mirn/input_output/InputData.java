package com.go_java4.alex_mirn.input_output;

import java.io.IOException;

import com.go_java4.alex_mirn.input_output.printers.ConsolePrinter;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;

public class InputData {
	Printer printer;
	Reader reader;

	public InputData(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
	}

	public int inputData(int size) throws IOException {
		while (true) {
			int inputData = inputAccept();
			if (inputData > size || inputData < 0) {
				println("You entered invalid number. please try again");
			} else {
				return inputData;
			}
		}
	}

	public int inputAccept() throws IOException {
		try {
			String in = reader.readline();
			int inInt = Integer.parseInt(in);
			return inInt;
		} catch (NumberFormatException e) {
			println("You entered unacceptable character. "
					+ "Make a choise and press enter");
			return inputAccept();
		}
	}

	private void println(String string) {
		print(string + "\n");
	}

	private void print(String string) {
		printer.print(string);
	}

}
