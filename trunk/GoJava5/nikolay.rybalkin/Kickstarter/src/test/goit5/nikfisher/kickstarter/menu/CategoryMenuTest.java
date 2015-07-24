package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CategoryMenuTest {

    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given
        Categories categories = new InFileCategories("categories_test.txt");
        categories.add(new Category("Game"));

        Projects projects = new Projects();

        QuoteGenerate generator = mock(QuoteGenerate.class);
        InputOutputConsoleInterface io = mock(InputOutputConsoleInterface.class);

        Main main = new Main(categories, projects, io, generator);

        //when
        when(io.consoleScanInt()).thenReturn(0);

        main.run();

        //then
        verify(io, times(1)).println("Select category (or 0 to exit): ");
        verify(io, times(1)).println(null); //TODO временно, пока не решу все траблы с записью в файл и чтения из оного
    }

}