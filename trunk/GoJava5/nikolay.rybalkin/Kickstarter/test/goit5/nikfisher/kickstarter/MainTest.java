package test.goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.Test;
import org.mockito.Mockito;

public class MainTest{

    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given
        Categories categories = new Categories();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        categories.add(new Category("category3"));

        Projects projects = new Projects();

        InputOutputConsoleInterface io = Mockito.mock(InputOutputConsoleInterface.class);
        QuoteGenerate generator = Mockito.mock(QuoteGenerate.class);

        Main main = new Main(categories, projects, io, generator);

        //when
        Mockito.when(generator.quoteGenerate()).thenReturn("Test quote");
        Mockito.when(io.consoleScan()).thenReturn(1, 0, 0);

        main.run();

        //then
        Mockito.verify(io).print("Test quote");
        Mockito.verify(io).print("Select category (or 0 to exit):");
        Mockito.verify(io).print("[1) category1, 2) category2, 3) category3]");
        Mockito.verify(io).print("You selected category: category1");
        Mockito.verify(io).print("Projects in this category do not have to exit, enter 0");
        Mockito.verify(io).print(" ");
        Mockito.verify(io).print("Select category (or 0 to exit): ");
        Mockito.verify(io).print("[1) category1, 2) category2, 3) category3]");
        Mockito.verify(io).print("Sank!");
    }
}
