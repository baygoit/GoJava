package org.dens.kikstarter;

import org.dens.kikstarter.data.CategoryProducer;
import org.dens.kikstarter.data.CitationProducer;
import org.dens.kikstarter.face.ConsoleKikstarter;
import org.dens.kikstarter.face.ConsoleScanner;

public class Main {

	public static void main(String[] args) {
				
		CitationProducer citationProducer = new CitationProducer();
		CategoryProducer categoryProducer = new CategoryProducer();
		ConsoleScanner scanner = new ConsoleScanner();
		ConsoleKikstarter consoleKikstarter = new ConsoleKikstarter();
		
		consoleKikstarter.setCitations(citationProducer);
		consoleKikstarter.setCategoies(categoryProducer);
		consoleKikstarter.setPrinter(scanner);
		consoleKikstarter.setScanner(scanner);
		
		consoleKikstarter.start();

	}

}
