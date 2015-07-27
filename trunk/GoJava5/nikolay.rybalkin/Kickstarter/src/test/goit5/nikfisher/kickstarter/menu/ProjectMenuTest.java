package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.dao.*;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import goit5.nikfisher.kickstarter.view.View;
import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProjectMenuTest {

//    @After
//    public void cleanup(){
//        new File("project_test.txt").delete();
//    }

    @Test
    public void shouldMenuWithProjects() throws Exception {
        //given
//        InMemoryCategories categories = new InMemoryCategories();
//        Category category = new Category("category1");
//        categories.add(category);
//
//        InMemoryProjects projects = new InMemoryProjects();
//
//        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 10, 10, "Interesting game");
//        projects.add(project1);
//
//        project1.setHistory("history");
//        project1.setCategory(category);
//        project1.setVideo("Link Video");
//
//        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
//        QuoteGenerate generator = mock(QuoteGenerate.class);
//
//        Main main = new Main(io, generator);
//        View view = new View(io, projects, categories);
//        CategoryMenu categoryMenu = new CategoryMenu(io, projects, categories);
//
//        //when
//
//        //1 - выбор категории 1
//        //1 - выбор проекта 2
//        //0 - выход из проекта
//        //0 - выход из списка проектов
//        //0 - выход из списка категорий
//        //0 - выход из программы
//
//        when(io.consoleScanInt()).thenReturn(0, 0, 0, 0, 0, 0);
//
//        categoryMenu.categoryMenu();
//        view.createCategories();
//        main.run();
//
//        //then
//        verify(io, times(1)).println("[1) Game, 2) Design, 3) Technology]");
//        verify(io, times(1)).println("You selected category: Game");
    }

}