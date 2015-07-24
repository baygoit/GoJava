package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.menu.CategoryMenu;
import goit5.nikfisher.kickstarter.model.Categories;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import goit5.nikfisher.kickstarter.model.Projects;
import goit5.nikfisher.kickstarter.model.QuoteGenerate;

public class Main {

	private Categories categories;
	private Projects projects;
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

		CategoryMenu categoryMenu = new CategoryMenu(io,  projects, categories);
		categoryMenu.categoryMenu();

		io.println("Sank!");
	}
}



