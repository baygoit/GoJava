package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

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

        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Main main = new Main(categories, projects, io, generator);

        //when
        when(generator.quoteGenerate()).thenReturn("Test quote");
        when(io.consoleScanInt()).thenReturn(1, 0, 0);

        main.run();

        //then
        verify(io).println("Test quote");
        verify(io, times(2)).println(" ");
        verify(io, times(2)).println("Select category (or 0 to exit): ");
        verify(io, times(2)).println("[1) category1, 2) category2, 3) category3]");
        verify(io, times(1)).println("You selected category: category1");
        verify(io, times(1)).println("Projects in this category do not have to exit, enter 0");
        verify(io, times(2)).println(" ");
        verify(io, times(2)).println("Select category (or 0 to exit): ");
        verify(io, times(2)).println("[1) category1, 2) category2, 3) category3]");
        verify(io, times(1)).println("Thank you for using our service!");
    }

    @Test
    public void shouldMenuWithrojects() throws Exception {
        //given
        Categories categories = new Categories();
        Category category = new Category("category1");
        categories.add(category);

        Projects projects = new Projects();

        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 10, 10, "Interesting game");
        projects.add(project1);

        project1.setHistory("history");
//        project1.setFaq("QA");
        project1.setCategory(category);
        project1.setVideo("Link Video");

        Project project2 = new Project("Game2 \"Popcorn\"", 10000, 10, 10, "Interesting game");
        projects.add(project2);

        project2.setHistory("history");
//        project2.setFaq("QA");
        project2.setCategory(category);
        project2.setVideo("link video");

        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Main main = new Main(categories, projects, io, generator);

        //when
        when(generator.quoteGenerate()).thenReturn("Test quote");

        //1 - выбор категории 1
        //2 - выбор проекта 2
        //0 - выход из проекта
        //0 - выход из списка проектов
        //0 - выход из списка категорий
        //0 - выход из программы

        when(io.consoleScanInt()).thenReturn(1, 2, 0, 0, 0);

        main.run();

        //then
        verify(io).println("Test quote");
        verify(io, times(5)).println(" ");
        verify(io, times(2)).println("Select category (or 0 to exit): ");
        verify(io, times(2)).println("[1) category1]");
        verify(io, times(1)).println("You selected category: category1");
        verify(io, times(1)).println("Project name: Game1 \"Popcorn\"");
        verify(io, times(3)).println("Description: Interesting game");
        verify(io, times(3)).println("Need collected: 10000$");
        verify(io, times(3)).println("Already collected: 0$");
        verify(io, times(3)).println("Days remaining: 10");
        verify(io, times(4)).println("---------------------------------------");
        verify(io, times(5)).println(" ");
        verify(io, times(2)).println("Project name: Game2 \"Popcorn\"");
        verify(io, times(2)).println("Select project: [0...1 or 0 for exit to the projects list]");
//        verify(io, times(1)).println("You selected project: Game2 \"Popcorn\"");
        verify(io, times(1)).println("Project detail:");
        verify(io, times(1)).println("history");
        verify(io, times(2)).println("QA");
        verify(io, times(1)).println("Operations on the project: [0 - go to the list of projects, 1 - invest in the project]");
        verify(io, times(1)).println("Thank you for using our service!");
    }

    @Test
    public void shouldPrintProjectMenuWenSelectIt() throws Exception {
        //given
        Categories categories = new Categories();
        Category category = new Category("category");
        categories.add(category);

        Projects projects = new Projects();
        Project project = new Project("Game1 \"Popcorn\"", 10000, 10, 10, "Interesting game");
        projects.add(project);
        project.setCategory(category);

        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Main main = new Main(categories, projects, io, generator);

        //when
        when(generator.quoteGenerate()).thenReturn("Test quote");
        when(io.consoleScanInt()).thenReturn(1, 1, 1, 0, 0, 0);

        main.run();

        //then
        verify(io, times(2)).println("Operations on the project: [0 - go to the list of projects, 1 - invest in the project]");
        verify(io, times(1)).println("Thank you want to help!");
    }


    @Test
    public void shouldIncomeAmountToProjectWhenDonate() throws Exception {
        //given
        int TOTAL = 100;

        Categories categories = new Categories();
        Category category = new Category("category");
        categories.add(category);

        Projects projects = new Projects();
        Project project = new Project("Game1 \"Popcorn\"", TOTAL, 10, 10, "Interesting game");
        projects.add(project);
        project.setCategory(category);

        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Main main = new Main(categories, projects, io, generator);

        //when
        when(generator.quoteGenerate()).thenReturn("Test quote");
        when(io.consoleScanString()).thenReturn("1", "1", "1", "Nik", "000000000000", "25", "0", "0", "0");

        main.run();

        //then
        List<String> values = assertPrinted(io, 5);

        asseptPrinted(values, "Test quote");
//        asseptPrinted(TOTAL - 25, project.getAmount());
    }


    private void asseptPrinted(List<String> values, String expected) {
        assertTrue("Actual data" + values.toString() + "doesn't  contain" + expected,
                values.contains(expected));
    }

    private List<String> assertPrinted(InputOutputConsoleInterface io, int times) {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(io, times(times)).println(captor.capture());
        return captor.getAllValues();
    }
}