package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsole;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import goit5.nikfisher.kickstarter.view.View;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.util.Random;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CategoryMenuTest {

    @After
    public void cleanup(){
        new File("category_test.txt").delete();
    }

    @Test
    public void shouldCategoriesWenHaveCategories() throws Exception {
        //given
        Categories categories = new InMemoryCategories();
        categories.add(new Category("Game"));

        Projects projects = new InMemoryProjects();

        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);
        View view = new View(io, projects, categories);

        //when
        view.createCategories();
        when(io.consoleScanInt()).thenReturn(0, 0);

        //then
//        verify(io, times(1)).println("Select category (or 0 to exit): ");
//        verify(io, times(1)).println("[1) Game]");
    }


}