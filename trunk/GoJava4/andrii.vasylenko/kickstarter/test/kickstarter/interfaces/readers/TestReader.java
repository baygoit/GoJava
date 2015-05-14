package kickstarter.interfaces.readers;

import java.io.IOException;

public class TestReader implements Reader {

	private StringBuilder input = new StringBuilder();

	@Override
	public String getLine() throws IOException {
		int indexOfNewLine = input.indexOf("\r\n");
		String line = input.toString().substring(0, indexOfNewLine);
		input.delete(0, indexOfNewLine + "\r\n".length());
		return line;
	}

	public void append(String line) {
		input.append(line);
		input.append("\r\n");
	}

}
