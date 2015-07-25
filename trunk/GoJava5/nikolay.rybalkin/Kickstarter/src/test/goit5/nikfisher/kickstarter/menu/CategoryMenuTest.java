package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.After;
import org.junit.Test;

import java.io.File;

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
        Categories categories = new InFileCategories("test.txt");
        categories.add(new Category("Game"));

        Projects projects = new InMemoryProjects();

        QuoteGenerate generator = mock(QuoteGenerate.class);
        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);

//        Main main = new Main(categories, projects, io, generator);

        //when
        when(io.consoleScanInt()).thenReturn(0);

//        main.run();

        //then
        verify(io, times(1)).println("Select category (or 0 to exit): ");
        verify(io, times(1)).println("[1) Game]");
    }

    @Test
    public void shouldCategoriesWenNoeCategories() throws Exception {
        //given
        Categories categories = new InMemoryCategories();

        Projects projects = new InMemoryProjects();

        QuoteGenerate generator = mock(QuoteGenerate.class);
        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);

//        Main main = new Main(categories, projects, io, generator);

        //when
        when(io.consoleScanInt()).thenReturn(0);

//        main.run();

        //then
        verify(io, times(1)).println("Select category (or 0 to exit): ");
        verify(io, times(1)).println(null);
    }

}