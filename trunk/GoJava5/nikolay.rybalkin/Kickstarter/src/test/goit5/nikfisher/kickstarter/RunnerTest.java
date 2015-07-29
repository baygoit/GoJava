package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.dao.Categories;
import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.dao.Projects;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.model.QuoteGenerate;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RunnerTest {

    @Test
    public void shouldIncomeAmountToProjectWhenDonate() throws Exception {
        //given

        Categories categories = new InMemoryCategories();
        Category category = new Category("category");
        categories.add(category);

        Projects projects = new InMemoryProjects();
        Project project = new Project("Game1 \"Popcorn\"", 1000, 10, 10, "Interesting game");
        projects.add(project);
        project.setCategory(category);

        project.setHistory("History this project");
        project.setVideo("https://www.youtube.com");
        project.setQuestion("No one has asked the question.");
        project.setAnsver("Still no one answered");

        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Runner runner = new Runner(io, generator);

        //when
        when(generator.quoteGenerate()).thenReturn("Test quote");
        when(io.consoleScanInt()).thenReturn(1, 1, 1, 99, 000000000000, 25, 0, 0, 0);

        runner.run();

        //then
        verify(io, times(1)).println("Test quote");
        verify(io, times(11)).println(" ");
        verify(io, times(5)).println("Select category (or 0 to exit): ");
        verify(io, times(5)).println("[1) Game, 2) Design, 3) Technology]");
        verify(io, times(3)).println("You selected category: Game");
        verify(io, times(3)).println("Project name: Game \"Popcorn\"");
        verify(io, times(6)).println("Description: Interesting game");
        verify(io, times(6)).println("Need collected: 10000$");
        verify(io, times(6)).println("Already collected: 0$");
        verify(io, times(6)).println("Days remaining: 10");
        verify(io, times(6)).println("---------------------------------------");

    }
}