package nikfisher.kickstarter;

import nikfisher.kickstarter.dao.*;
import nikfisher.kickstarter.menu.CategoryMenu;
import nikfisher.kickstarter.streams.ConsoleIO;
import nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    final private ConsoleInterfaceIO IO;
    final private QuoteDAO GENERATOR;
    private Categories categories = new CategoriesDAO();
    private Projects projects = new ProjectsDAO();


    private final static Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public Runner(ConsoleInterfaceIO io, QuoteDAO generator) {
        this.IO = io;
        this.GENERATOR = generator;
    }

    public void run() {

        IO.println(GENERATOR.quoteGenerate());
        CategoryMenu categoryMenu = new CategoryMenu(IO, projects, categories);
        categoryMenu.categoryMenu();
        IO.println("Thank you for using our service!");
    }

    public static void main(String[] args){

        LOGGER.info("The successful launch of the program.");
        Runner runner = new Runner(new ConsoleIO(), new QuoteDAO());
        runner.run();
        LOGGER.info("Finished program.");
    }
}



