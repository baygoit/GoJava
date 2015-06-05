package kickstarter.page;

import java.io.IOException;

import kickstarter.printer.Printer;
import kickstarter.reader.Reader;

public class InputData {
	Printer printer;
	Reader reader;
	
	public InputData(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader =  reader;
	}

	public int inputData(int size) throws IOException {
		while (true) {
			int inputData = inputAccept();
			if (inputData > size || inputData < 0) {
				printer.println("You entered invalid number. Please try again");
			} else {
				return inputData;
			}
		}
	}

	private int inputAccept() throws IOException {
		try {
			String in = reader.readline();
			int inInt = Integer.parseInt(in);
			return inInt;
		} catch (NumberFormatException e) {
			printer.println("You entered unacceptable character. Make a choice and press enter.");
			return inputAccept();
		}
	}
	
	
}
