package go_java_4.vadya_zakusylo.kickstarter;

import go_java_4.vadya_zakusylo.kickstarterPrinter.Console;
import go_java_4.vadya_zakusylo.kickstarterPrinter.Printer;
import go_java_4.vadya_zakusylo.kickstarterRepository.Content;
import go_java_4.vadya_zakusylo.kickstarterRepository.CreativeQuote;
import go_java_4.vadya_zakusylo.kickstarterRepository.Quote;

public class Runner {
	private static Quote quote = new CreativeQuote();
	private static Content content = new Content();
	private static Printer printer = new Console();

	public static void main(String[] args) {
		KickStarter kickStarter = new KickStarter(quote, content, printer);
		kickStarter.go();
	}

}
