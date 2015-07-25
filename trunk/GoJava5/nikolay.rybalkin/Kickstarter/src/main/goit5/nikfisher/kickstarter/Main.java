package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import goit5.nikfisher.kickstarter.view.View;

public class Main {

	private InputOutputConsoleInterface io;
	private QuoteGenerate generator;

	public Main( InputOutputConsoleInterface io, QuoteGenerate generator) {
		this.io = io;
		this.generator = generator;
	}

	public void run() {

		io.println(generator.quoteGenerate());

		View view = new View(io, new InMemoryProjects(), new InMemoryCategories() );
		view.createCategories();

		io.println("Sank!");
	}
}



