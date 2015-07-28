package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.dao.Categories;
import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.dao.Projects;
import goit5.nikfisher.kickstarter.menu.CategoryMenu;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;

import static org.mockito.Mockito.*;

public class MainTest {


    @After
    public void cleanup() {
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
}
