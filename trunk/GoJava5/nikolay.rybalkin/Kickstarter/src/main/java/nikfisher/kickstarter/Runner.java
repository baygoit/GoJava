package nikfisher.kickstarter;

import nikfisher.kickstarter.dao.Categories;
import nikfisher.kickstarter.dao.CategoriesDAO;
import nikfisher.kickstarter.dao.InMemoryProjects;
import nikfisher.kickstarter.model.QuoteGenerate;
import nikfisher.kickstarter.streams.ConsoleIO;
import nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import nikfisher.kickstarter.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Runner {

    final private ConsoleInterfaceIO IO;
    final private QuoteGenerate GENERATOR;
    private Categories categories = new CategoriesDAO();


    private final static Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public Runner(ConsoleInterfaceIO io, QuoteGenerate generator) {
        this.IO = io;
        this.GENERATOR = generator;
    }

    public void run() {

        IO.println(GENERATOR.quoteGenerate());
        View view = new View(IO, new InMemoryProjects(), categories);
        view.createCategories();
        IO.println("Thank you for using our service!");
    }

    public static void main(String[] args){

        LOGGER.info("The successful launch of the program.");
        Runner runner = new Runner(new ConsoleIO(), new QuoteGenerate(new Random()));
        runner.run();
        LOGGER.info("Finished program.");
    }
}



