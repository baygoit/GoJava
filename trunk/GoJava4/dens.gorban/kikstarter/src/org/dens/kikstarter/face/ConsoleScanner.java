package org.dens.kikstarter.face;

import java.io.PrintStream;
import java.util.Scanner;

import org.dens.kikstarter.data.CategoryProducer;
import org.dens.kikstarter.data.CitationProducer;

public class ConsoleScanner implements Printer, Reader{
	public PrintStream out = System.out;
	public Scanner in = new Scanner(System.in);
	
	private static String DECORATION = "************* %s ************* \n";
	private static String DELIMITER = "================================================ \n";
	private static String OPTION = " %d. %s \n";

	public ConsoleScanner() {
		
	}

	@Override
	public String read() {		
		return in.nextLine();
	}

	@Override
	public void printBlock(String header, String... options) {
		printHeader(header);
		for(int index = 0; index < options.length; index++){
			out.printf(OPTION, index, options[index]);
		}		
		out.println(DELIMITER);
	}
	@Override
	public void printHeader(String text) {
		out.printf(DECORATION, text);
	}
	@Override
	public void printOption(int index, String text) {
		out.printf(OPTION, index, text);
	}

	@Override
	public void printLine(String text, boolean decorate) {
		if(decorate) out.printf(DECORATION, "");
		out.println(text);
		if(decorate) out.printf(DECORATION, "");

	}
}