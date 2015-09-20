package ua.com.goit.gojava.kickstarter.input;

public class Reader {
	private Input consolReader;

	public Reader(Input reader) {
		this.consolReader = reader;
	}

	public int readInt() {
		return Integer.valueOf(consolReader.read());
	}

}
