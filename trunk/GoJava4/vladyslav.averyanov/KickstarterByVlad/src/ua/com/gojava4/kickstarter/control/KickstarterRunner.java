package ua.com.gojava4.kickstarter.control;

import ua.com.gojava4.kickstarter.view.ConsoleReader;
import ua.com.gojava4.kickstarter.view.ConsoleWriter;
import ua.com.gojava4.kickstarter.view.Reader;
import ua.com.gojava4.kickstarter.view.Writer;

public class KickstarterRunner {

	public static void main(String[] args) {
		Reader reader = new ConsoleReader();
		Writer writer = new ConsoleWriter();
		Kickstarter kickstarter = new Kickstarter(reader, writer);
		kickstarter.run();
	}

}
