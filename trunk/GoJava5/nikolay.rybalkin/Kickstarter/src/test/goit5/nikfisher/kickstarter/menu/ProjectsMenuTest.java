package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.dao_old.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao_old.InMemoryProjects;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.model.QuoteGenerate;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProjectsMenuTest {

    @Test
    public void shouldMenuWithProjects() throws Exception {
        //given
        InMemoryCategories categories = new InMemoryCategories();
        Category category = new Category("category1");
        categories.add(category);

        InMemoryProjects projects = new InMemoryProjects();

        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 0, 10, "Interesting game");
        projects.add(project1);

        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Main main = new Main(io, generator);
//        View view = new View(io, projects, categories);

        //when

        //1 - ����� ��������� 1
        //0 - ����� �� ���������
        //0 - ����� �� �������

        when(io.consoleScanInt()).thenReturn(1, 0, 0);

//        view.createCategories();
        main.run();

        //then
        verify(io, times(3)).println("You selected category: Game");
        verify(io, times(3)).println("1)");
        verify(io, times(3)).println("Project name: Game \"Popcorn\"");
        verify(io, times(3)).println("Description: Interesting game");
        verify(io, times(3)).println("Need collected: 10000$");
        verify(io, times(3)).println("Already collected: 0$");
        verify(io, times(3)).println("Days remaining: 10");

    }
}