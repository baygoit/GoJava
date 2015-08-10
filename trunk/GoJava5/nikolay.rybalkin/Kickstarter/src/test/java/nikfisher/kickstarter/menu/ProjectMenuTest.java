package nikfisher.kickstarter.menu;

import nikfisher.kickstarter.Runner;
import nikfisher.kickstarter.dao.CategoriesDAO;
import nikfisher.kickstarter.dao.InMemoryProjects;
import nikfisher.kickstarter.model.Category;
import nikfisher.kickstarter.model.Project;
import nikfisher.kickstarter.model.QuoteGenerate;
import nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.Test;

import static org.mockito.Mockito.*;

@SuppressWarnings("deprecation")
public class ProjectMenuTest{

    @Test
    public void shouldMenuWithProjectDetail() {
        //given
        CategoriesDAO categories = new CategoriesDAO();
        Category category = new Category("category1");
        categories.add(category);

        InMemoryProjects projects = new InMemoryProjects();

        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 0, 10, "Interesting game");
        projects.add(project1);

        project1.setHistory("History this project");
        project1.setVideo("https://www.youtube.com");
        project1.setQuestion("No one has asked the question.");
        project1.setAnswer("Still no one answered");

        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Runner runner = new Runner(io, generator);

        //when

        //1 - выбор категории 1
        //1 - выбор проекта 1
        //0 - выход из проекта
        //0 - выход из списка проектов
        //0 - выход из списка категорий
        //0 - выход из программы

        when(io.consoleScanInt()).thenReturn(1, 1, 0, 0, 0, 0);
        runner.run();

        //then
        verify(io, times(3)).println("---------------------------------------");
        verify(io, times(1)).println("History this project");
        verify(io, times(1)).println("https://www.youtube.com");
        verify(io, times(1)).println("No one has asked the question.");
        verify(io, times(1)).println("Still no one answered");
        verify(io, times(3)).println("---------------------------------------");
    }

    @Test
    public void shouldMenuWithProjectPayment() {
        //given
        CategoriesDAO categories = new CategoriesDAO();
        Category category = new Category("category1");
        categories.add(category);

        InMemoryProjects projects = new InMemoryProjects();

        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 0, 10, "Interesting game");
        projects.add(project1);

        project1.setHistory("History this project");
        project1.setVideo("https://www.youtube.com");
        project1.setQuestion("No one has asked the question.");
        project1.setAnswer("Still no one answered");

        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Runner runner = new Runner(io, generator);

        //when

        //1 - выбор категории 1
        //1 - выбор проекта 1
        //0 - выход из проекта
        //0 - выход из списка проектов
        //0 - выход из списка категорий
        //0 - выход из программы

        when(io.consoleScanInt()).thenReturn(1, 1, 1, 1, 0, 0);

        runner.run();

        //then
        verify(io, times(4)).println("---------------------------------------");
        verify(io, times(1)).println("History this project");
        verify(io, times(1)).println("https://www.youtube.com");
        verify(io, times(1)).println("No one has asked the question.");
        verify(io, times(1)).println("Still no one answered");
        verify(io, times(4)).println("---------------------------------------");
    }
}