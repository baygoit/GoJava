package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.Runner;
import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.dao.Projects;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.model.QuoteGenerate;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

@SuppressWarnings("deprecation")
public class ProjectsMenuTest {

    @Mock
    final InMemoryCategories CATEGORIES = new InMemoryCategories();

    @Test
    public void shouldCategoriesWhenHaveProjects() {
        //given
        Category category1 = new Category("Game");
        CATEGORIES.add(category1);

        Project project1 = new Project("Game \"Popcorn\"", 10000, 0, 10, "Interesting game");
        Projects projects = new InMemoryProjects();
        project1.setCategory(category1);
        projects.add(project1);

        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Runner runner = new Runner(io, generator);

        //when
        when(io.consoleScanInt()).thenReturn(1, 0, 0);
        runner.run();

        //then
        verify(io, times(1)).println("You selected category: Game");
        verify(io, times(3)).println(" ");
        verify(io, times(1)).println("Project name: Game \"Popcorn\"");
        verify(io, times(1)).println("Description: Interesting game");
        verify(io, times(1)).println("Need collected: 10000$");
        verify(io, times(1)).println("Already collected: 0$");
        verify(io, times(1)).println("Days remaining: 10");
        verify(io, times(1)).println("Project name: Game \"Popcorn\"");
        verify(io, times(1)).println("Thank you for using our service!");
    }
}