package org.dens.kikstarter;

import org.dens.kikstarter.face.StatesConsoleKikstarter;

public class Main {

	public static void main(String[] args) {
	
		IConsoleKikstarter consoleKikstarter = new StatesConsoleKikstarter();
		consoleKikstarter.start();
	}
	
}
