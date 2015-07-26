package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.dao.Categories;
import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.dao.Projects;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import goit5.nikfisher.kickstarter.view.View;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;

import static org.mockito.Mockito.*;
public class CategoryMenuTest {

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
        View view = new View(io, projects, categories);
        //when

        when(io.consoleScanInt()).thenReturn(1, 0);
        view.createCategories();

        //then
        verify(io, times(1)).println("Select category (or 0 to exit): ");
        verify(io, times(1)).println(" ");
        verify(io, times(1)).println("[1) Game]");
    }


}