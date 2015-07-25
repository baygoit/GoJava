package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProjectMenuTest {

    @After
    public void cleanup(){
        new File("project_test.txt").delete();
    }

    @Test
    public void shouldMenuWithProjects() throws Exception {
        //given
        Categories categories = new InFileCategories("project_test.txt");
        Category category = new Category("category1");
        categories.add(category);

        Projects projects = new InMemoryProjects();

        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 10, 10, "Interesting game");
        projects.add(project1);

        project1.setHistory("history");
        project1.setCategory(category);
        project1.setVideo("Link Video");

        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

//        Main main = new Main(categories, projects, io, generator);

        //when

        //1 - выбор категории 1
        //2 - выбор проекта 2
        //0 - выход из проекта
        //0 - выход из списка проектов
        //0 - выход из списка категорий
        //0 - выход из программы

        when(io.consoleScanInt()).thenReturn(0, 0, 0, 0, 0, 0);

//        main.run();

        //then
        verify(io, times(3)).println("Thank you want to help!");
    }

}