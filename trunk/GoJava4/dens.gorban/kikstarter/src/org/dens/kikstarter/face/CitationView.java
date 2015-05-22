package org.dens.kikstarter.face;

import org.dens.kikstarter.data.CitationProducer;

public class CitationView implements View{
	
	private CitationProducer producer = new CitationProducer();
	private ConsoleScanner scanner = new ConsoleScanner();
	
	@Override
	public void printInfo() {
		scanner.printLine(producer.next().toString(), true);		
	}

	@Override
	public void action(ViewState viewState) {
		viewState.setView(new CategoryView());
	}

}
