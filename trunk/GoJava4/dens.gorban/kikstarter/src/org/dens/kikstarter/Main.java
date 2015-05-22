package org.dens.kikstarter;

import org.dens.kikstarter.data.CategoryProducer;
import org.dens.kikstarter.data.CitationProducer;
import org.dens.kikstarter.face.CitationView;
import org.dens.kikstarter.face.ConsoleKikstarter;
import org.dens.kikstarter.face.ConsoleScanner;
import org.dens.kikstarter.face.StatesConsoleKikstarter;

public class Main {

	public static void main(String[] args) {
	
		IConsoleKikstarter consoleKikstarter = new StatesConsoleKikstarter();
		consoleKikstarter.start();
	}

}
