package tyomsky.kickstarter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class KickstarterTest {

    private static final int EXIT_CODE = 0;

    @Mock
    QuoteGenerator mockQuoteGenerator;

    @Mock
    IO mockIO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    class FakeIO implements IO {

        private List<String> messages = new LinkedList<>();
        private List<String> input = new LinkedList<>();

        @Override
        public String read() {
            return input.remove(0);
        }

        @Override
        public void println(String message) {
            messages.add(message);
        }

        public FakeIO(String... input) {
            this.input = new LinkedList<>(Arrays.asList(input));
        }

        public List<String> getMessages() {
            return messages;
        }

        public List<String> getInput() {
            return input;
        }
    }

    class StabQuoteGenerator extends QuoteGenerator {

        private String quote;

        public StabQuoteGenerator() {
            super(new Random());
        }

        @Override
        public String getQuote() {
            return "quote";
        }
    }
    @Test
    public void fakeCategoryNavigation () {
        FakeIO io = new FakeIO("1", "0", "0");
        Categories categories = new Categories();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        Kickstarter kickstarter = new Kickstarter(categories, new Projects(), io, new StabQuoteGenerator());
        kickstarter.run();
        assertEquals("[quote," +
                " 1: category1," +
                " 2: category2," +
                " Select item (0 for exit)," +
                " You have chosen: category1," +
                " ------------------------------------------------------," +
                " nothing to do here.," +
                " Select item (0 for exit)," +
                " 1: category1," +
                " 2: category2," +
                " Select item (0 for exit)]", io.getMessages().toString());
    }

    @Test
    public void fakeCategoryAndProjectsNavigation () {
        FakeIO io = new FakeIO("1", "0", "0");
        Categories categories = new Categories();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        Projects projects = new Projects();
        projects.add(new Project("project1", "project1 desc", 100, 10, "link1", categories.get(0)));
        projects.add(new Project("project2", "project2 desc", 100, 10, "link2", categories.get(0)));
        Kickstarter kickstarter = new Kickstarter(categories, projects, io, new StabQuoteGenerator());
        kickstarter.run();
        assertEquals("[quote, " +
                "1: category1, " +
                "2: category2, " +
                "Select item (0 for exit), " +
                "You have chosen: category1, " +
                "------------------------------------------------------, " +
                "1: project1 \n" +
                "project1 desc \n" +
                "Need to collect - 100$. Collected - 0$. Days left - 10, " +
                "------------------------------------------------------, " +
                "2: project2 \n" +
                "project2 desc \n" +
                "Need to collect - 100$. Collected - 0$. Days left - 10, " +
                "------------------------------------------------------, " +
                "Select item (0 for exit), " +
                "1: category1, " +
                "2: category2, " +
                "Select item (0 for exit)]", io.getMessages().toString());
    }

    @Test
    public void shouldPrintPaymentMenu_whenRequested() {
        when(mockQuoteGenerator.getQuote()).thenReturn("quote");
        when(mockIO.read()).thenReturn("1","1","1","0","0","0");
        Categories categories = new Categories();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        Projects projects = new Projects();
        projects.add(new Project("project1", "project1 desc", 100, 10, "link1", categories.get(0)));
        projects.add(new Project("project2", "project2 desc", 100, 10, "link2", categories.get(0)));
        Kickstarter kickstarter = new Kickstarter(categories, projects, mockIO, mockQuoteGenerator);
        kickstarter.run();

        verify(mockIO).println("Thanks for helping our project");
    }

}