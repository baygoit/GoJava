package test.goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class MainTest{

    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given
        Categories categories = new Categories();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        categories.add(new Category("category3"));

        Projects projects = new Projects();

        InputOutputConsoleInterface io = Mockito.mock(InputOutputConsoleInterface.class);
        QuoteGenerate generator = Mockito.mock(QuoteGenerate.class);

        Main main = new Main(categories, projects, io, generator);

        //when
        Mockito.when(generator.quoteGenerate()).thenReturn("Test quote");
        Mockito.when(io.consoleScan()).thenReturn(1, 0, 0);

        main.run();

        //then
        Mockito.verify(io).println("Test quote");
        Mockito.verify(io, times(2)).println(" ");
        Mockito.verify(io, times(2)).println("Select category (or 0 to exit): ");
        Mockito.verify(io, times(2)).println("[1) category1, 2) category2, 3) category3]");
        Mockito.verify(io, times(1)).println("You selected category: category1");
        Mockito.verify(io, times(1)).println("Projects in this category do not have to exit, enter 0");
        Mockito.verify(io, times(2)).println(" ");
        Mockito.verify(io, times(2)).println("Select category (or 0 to exit): ");
        Mockito.verify(io, times(2)).println("[1) category1, 2) category2, 3) category3]");
        Mockito.verify(io, times(1)).println("Sank!");
    }

    @Test
    public void shouldMenuWithrojects() throws Exception {
        //given
        Categories categories = new Categories();
        Category category = new Category("category1");
        categories.add(category);

        Projects projects = new Projects();

        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 10, "Interesting game");
        projects.add(project1);

        project1.setHistory("history");
        project1.setFaq("QA");
        project1.setCategory(category);
        project1.setVideo("Link Video");

        Project project2 = new Project("Game2 \"Popcorn\"", 10000, 10, "Interesting game");
        projects.add(project2);

        project2.setHistory("history");
        project2.setFaq("QA");
        project2.setCategory(category);
        project2.setVideo("Link Video");

        InputOutputConsoleInterface io = Mockito.mock(InputOutputConsoleInterface.class);
        QuoteGenerate generator = Mockito.mock(QuoteGenerate.class);

        Main main = new Main(categories, projects, io, generator);

        //when
        Mockito.when(generator.quoteGenerate()).thenReturn("Test quote");
        Mockito.when(io.consoleScan()).thenReturn(1, 1, 0, 0, 0);

        main.run();

        //then
        Mockito.verify(io).println("Test quote");
        Mockito.verify(io, times(5)).println(" ");
        Mockito.verify(io, times(2)).println("Select category (or 0 to exit): ");
        Mockito.verify(io, times(2)).println("[1) category1]");
        Mockito.verify(io, times(1)).println("You selected category: category1");
        Mockito.verify(io, times(2)).println("goit5.nikfisher.kickstarter.model.Project name: Game1 \"Popcorn\"");
        Mockito.verify(io, times(3)).println("Description: Interesting game");
        Mockito.verify(io, times(3)).println("Need collected: 10000$");
        Mockito.verify(io, times(3)).println("Already collected: 0$");
        Mockito.verify(io, times(3)).println("Days remaining: 10");
        Mockito.verify(io, times(4)).println("---------------------------------------");
        Mockito.verify(io, times(5)).println(" ");
        Mockito.verify(io, times(1)).println("goit5.nikfisher.kickstarter.model.Project name: Game2 \"Popcorn\"");
        Mockito.verify(io, times(2)).println("Select project: [0...1 or 0 for exit to the projects list");
        Mockito.verify(io, times(1)).println("You selected project: Game1 \"Popcorn\"");
        Mockito.verify(io, times(1)).println("goit5.nikfisher.kickstarter.model.Project detail:");
        Mockito.verify(io, times(1)).println("history");
        Mockito.verify(io, times(2)).println("QA");
        Mockito.verify(io, times(1)).println("Sank!");
    }
}