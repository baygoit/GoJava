package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.dao.Categories;
import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.dao.Projects;
import goit5.nikfisher.kickstarter.menu.CategoryMenu;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainTest {


    @After
    public void cleanup(){
        new File("category_test.txt").delete();
    }

    @Mock
    Categories categories = new InMemoryCategories();

    @Test
    public void shouldCategoriesWenHaveCategories() throws Exception {
        //given

        categories.add(new Category("Game"));

        Projects projects = new InMemoryProjects();

        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        CategoryMenu categoryMenu = new CategoryMenu(io, projects, categories);
        //when
        categoryMenu.categoryMenu();
        when(io.consoleScanInt()).thenReturn(1, 0);

        //then
        verify(io, times(1)).println("Select category (or 0 to exit): ");
        verify(io, times(1)).println("[1) Game]");
    }

    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given

        Projects projects = new InMemoryProjects();

        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        CategoryMenu categoryMenu = new CategoryMenu(io, projects, categories);
        //when
        categoryMenu.categoryMenu();
        when(io.consoleScanInt()).thenReturn(1, 0);

        //then
        verify(io, times(1)).println("Select category (or 0 to exit): ");
        verify(io, times(1)).println("[]");
    }

    @Test
    public void shouldCategoriesWenHaveProjects() throws Exception {
        //given
        Categories categories = new InMemoryCategories();
        Category category = new Category("[category1]");
        categories.add(category);

        Projects projects = new InMemoryProjects();

        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 10, 10, "Interesting game");
        projects.add(project1);

        project1.setCategory(category);
        project1.setHistory("history");
        project1.setVideo("Link Video");

        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        CategoryMenu categoryMenu = new CategoryMenu(io, projects, categories);

        //when
        when(generator.quoteGenerate()).thenReturn("Test quote");

        //1 - выбор категории 1
        //1 - выбор проекта 2
        //0 - выход из проекта
        //0 - выход из списка проектов
        //0 - выход из списка категорий
        //0 - выход из программы
        categoryMenu.categoryMenu();
        when(io.consoleScanInt()).thenReturn(1, 1, 0, 0, 0);



        //then
        verify(io, times(1)).println("Select category (or 0 to exit): ");
        verify(io, times(1)).println(" ");
        verify(io, times(1)).println("[1) [category1]]");
        verify(io, times(3)).println("Description: Interesting game");
        verify(io, times(3)).println("Need collected: 10000$");
        verify(io, times(3)).println("Already collected: 0$");
        verify(io, times(3)).println("Days remaining: 10");
        verify(io, times(4)).println("---------------------------------------");
    }

}

//    Select category (or 0 to exit):
//        [1) Game, 2) Design, 3) Technology]
//        1
//        You selected category: Game
//        1)
//        Project name: Game "Popcorn"
//        Description: Interesting game
//        Need collected: 10000$
//        Already collected: 0$
//        Days remaining: 10
//        ---------------------------------------