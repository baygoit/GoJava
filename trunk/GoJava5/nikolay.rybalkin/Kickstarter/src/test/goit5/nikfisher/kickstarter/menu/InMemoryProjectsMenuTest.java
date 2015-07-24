package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class InMemoryProjectsMenuTest {

    @After
    public void cleanup(){
        new File("category_test.txt").delete();
    }

    @Test
    public void shouldCategoriesWenHaveProjects() throws Exception {
//        //given
//        Categories categories = new InFileCategories("category_test.txt");
//        Category category = new Category("[category1]");
//        categories.add(category);
//
//        Projects projects = new Projects();
//
//        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 10, 10, "Interesting game");
//        projects.add(project1);
//
//        project1.setCategory(category);
//        project1.setHistory("history");
//        project1.setVideo("Link Video");
//
//        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);
//        QuoteGenerate generator = mock(QuoteGenerate.class);
//
//        Main main = new Main(categories, projects, io, generator);
//
//        //when
//        when(generator.quoteGenerate()).thenReturn("Test quote");
//
//        //1 - выбор категории 1
//        //2 - выбор проекта 2
//        //0 - выход из проекта
//        //0 - выход из списка проектов
//        //0 - выход из списка категорий
//        //0 - выход из программы
//
//        when(io.consoleScanInt()).thenReturn(2, 1, 0, 0, 0);
//
//        main.run();
//
//        //then
//        verify(io, times(1)).println("Select category (or 0 to exit): ");
//        verify(io, times(1)).println("Test quote");
//        verify(io, times(1)).println(" ");
//        verify(io, times(1)).println("[1) [category1]]");
//        verify(io, times(3)).println("Description: Interesting game");
//        verify(io, times(3)).println("Need collected: 10000$");
//        verify(io, times(3)).println("Already collected: 0$");
//        verify(io, times(3)).println("Days remaining: 10");
//        verify(io, times(4)).println("---------------------------------------");
    }
}