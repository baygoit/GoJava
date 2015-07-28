package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.dao.InMemoryCategories;
import goit5.nikfisher.kickstarter.dao.InMemoryProjects;
import goit5.nikfisher.kickstarter.dao.Projects;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.QuoteGenerate;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class CategoryMenuTest {

//    @After
//    public void cleanup(){
//        new File("category_test.txt").delete();
//    }

    @Mock
    InMemoryCategories categories = new InMemoryCategories();

    @Test
    public void shouldCategoriesWenHaveCategories() throws Exception {
        //given

        categories.add(new Category("Game"));

        Projects projects = new InMemoryProjects();
        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Main main = new Main(io, generator);
//        View view = new View(io, projects, categories);
        CategoryMenu categoryMenu = new CategoryMenu(io, projects, categories);

        //when

        when(io.consoleScanInt()).thenReturn(1, 0, 0);
        categoryMenu.categoryMenu();
//        view.createCategories();
        main.run();


        //then
        verify(io, times(1)).println("[1) Game]");
        verify(io, times(1)).println("You selected category: Game");
    }

    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given
        Projects projects = new InMemoryProjects();
        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Main main = new Main(io, generator);
//        View view = new View(io, projects, categories);
        CategoryMenu categoryMenu = new CategoryMenu(io, projects, categories);

        //when

        when(io.consoleScanInt()).thenReturn(0);
        categoryMenu.categoryMenu();
//        view.createCategories();
//        main.run();


        //then
        verify(io, times(1)).println("[]");
    }

}
