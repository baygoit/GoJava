package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.fileStorage.QuoteFileStorage;

public class KickstarterFromFiles {
	private ConsoleReader consoleReader;
	private ConsolePrinter consolePrinter;
	private QuoteFileStorage quoteFileStorage;

	public KickstarterFromFiles(ConsoleReader consoleReader, ConsolePrinter consolePrinter, QuoteFileStorage quoteFileStorage) {
		this.consoleReader = consoleReader;
		this.consolePrinter = consolePrinter;
		this.quoteFileStorage = quoteFileStorage;
	}

	public void start() throws IOException {
		consolePrinter.println(quoteFileStorage.getRandomQuote());
	}

	public void stop() throws IOException {
		consoleReader.closeReader();
	}
}
