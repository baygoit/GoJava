package go_java_4.vadya_zakusylo.kickstarter;

import go_java_4.vadya_zakusylo.kickstarter.input.ConsoleInput;
import go_java_4.vadya_zakusylo.kickstarter.input.Input;
import go_java_4.vadya_zakusylo.kickstarter.output.ConsoleOutput;
import go_java_4.vadya_zakusylo.kickstarter.output.Output;
import go_java_4.vadya_zakusylo.kickstarter.repository.ContentInterface;
import go_java_4.vadya_zakusylo.kickstarter.repository.Content;
import go_java_4.vadya_zakusylo.kickstarter.repository.Quote;
import go_java_4.vadya_zakusylo.kickstarter.repository.QuoteInterface;

public class Main {
	private static QuoteInterface quote = new Quote();
	private static ContentInterface content = new Content();
	private static Output output = new ConsoleOutput();
	private static Input input = new ConsoleInput();

	public static void main(String[] args) {
		KickStarter kickStarter = new KickStarter(quote, content, output, input);
		kickStarter.go();
	}

}
