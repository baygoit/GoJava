package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.menu.CategoryMenu;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;

public class Main {

	private final Projects projects;
	private Categories categories;
	private InputOutputConsoleInterface io;
	private QuoteGenerate generator;

	public Main(Categories categories, Projects projects, InputOutputConsoleInterface io, QuoteGenerate generator) {

		this.categories = categories;
		this.projects = projects;
		this.io = io;
		this.generator = generator;
	}

	public void run() {

		io.println(generator.quoteGenerate());

		CategoryMenu categoryMenu = new CategoryMenu(io, projects, categories);
		categoryMenu.categoryMenu();

		io.println("Sank!");
	}
}



