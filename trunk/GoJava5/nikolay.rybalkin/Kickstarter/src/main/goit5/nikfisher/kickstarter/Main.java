package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.menu.CategoryMenu;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import goit5.nikfisher.kickstarter.view.View;

public class Main {

	private Projects projects;
	private Categories categories;
	private InputOutputConsoleInterface io;
	private QuoteGenerate generator;

	public Main( InputOutputConsoleInterface io, QuoteGenerate generator) {

		this.categories = categories;
		this.projects = projects;
		this.io = io;
		this.generator = generator;
	}

	public void run() {

		io.println(generator.quoteGenerate());

		View view = new View();
		view.createCategories();

		io.println("Sank!");
	}
}



