package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.model.QuoteGenerate;
import goit5.nikfisher.kickstarter.streams.ConsoleIO;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import goit5.nikfisher.kickstarter.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Runner {

    private ConsoleInterfaceIO io;
    private QuoteGenerate generator;
    private int id;
    private String name;

    final static Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public Runner(ConsoleInterfaceIO io, QuoteGenerate generator) {
        this.io = io;
        this.generator = generator;
    }

    public void run() {

        io.println(generator.quoteGenerate());
        View view = new View(io, new Project(), new InMemoryProjects(), new Category(id, name), new InMemoryCategories());
        view.createCategories();
        io.println("Thank you for using our service!");
    }

    public static void main(String[] args){

        LOGGER.info("The successful launch of the program.");
        Runner runner = new Runner(new ConsoleIO(), new QuoteGenerate(new Random()));
        runner.run();
        LOGGER.info("Finished program.");
    }
}



