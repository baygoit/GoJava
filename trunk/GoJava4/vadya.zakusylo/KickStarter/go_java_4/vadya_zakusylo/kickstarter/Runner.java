package go_java_4.vadya_zakusylo.kickstarter;

import go_java_4.vadya_zakusylo.kickstarter.input.ConsoleInput;
import go_java_4.vadya_zakusylo.kickstarter.input.Input;
import go_java_4.vadya_zakusylo.kickstarter.output.ConsoleOutput;
import go_java_4.vadya_zakusylo.kickstarter.output.Output;
import go_java_4.vadya_zakusylo.kickstarter.repository.Content;
import go_java_4.vadya_zakusylo.kickstarter.repository.ContentImpl;
import go_java_4.vadya_zakusylo.kickstarter.repository.CreativeQuote;
import go_java_4.vadya_zakusylo.kickstarter.repository.Quote;

public class Runner {
	private static Quote quote = new CreativeQuote();
	private static Content content = new ContentImpl();
	private static Output output = new ConsoleOutput();
	private static Input input = new ConsoleInput();

	public static void main(String[] args) {
		KickStarter kickStarter = new KickStarter(quote, content, output, input);
		kickStarter.go();
	}

}
