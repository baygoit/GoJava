package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.model.QuoteGenerate;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import goit5.nikfisher.kickstarter.view.View;

public class Main {

    private ConsoleInterfaceIO io;
    private QuoteGenerate generator;
    private int id;
    private String name;

    public Main(ConsoleInterfaceIO io, QuoteGenerate generator) {
        this.io = io;
        this.generator = generator;
    }

    public void run() {

        io.println(generator.quoteGenerate());

        View view = new View(io, new Project(), new InMemoryProjects(), new Category(id, name), new InMemoryCategories());
        view.createCategories();

        io.println("Sank!");
    }
}



