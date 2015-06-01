package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class Kickstarter {
	
	Reader reader;
	Writer writer;

	public Kickstarter(Reader reader, Writer writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public void run() {
		
	}
}
