package ua.com.goit.gojava7.kickstarter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.InMemoryCategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.InMemoryQuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.util.ConsoleMock;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;
import ua.com.goit.gojava7.kickstarter.view.View;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelpPageTest {
    private PrintStream oldOut;
    private ByteArrayOutputStream out;
    private InputStream oldIn;
    private ConsoleMock.ConfigurableInputStream in;

    @Before
    public void setUpStreams() {
        oldIn = System.in;

        in = new ConsoleMock.ConfigurableInputStream();

        oldOut = System.out;

        out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    @Test
    public void test() {
        List<Quote> quotes = Arrays.asList(new Quote("text1", "author1"));
        QuoteStorage quoteStorage = new InMemoryQuoteStorage(quotes);
        Category category = new Category("category1");
        List<Category> categories = Arrays.asList(category);
        new Project("project1", category, "description", "description", "history", "http://...", 1_000_000, 7);
        CategoryStorage categoryStorage = new InMemoryCategoryStorage(categories);

        Kickstarter kickstarter = new Kickstarter(categoryStorage, quoteStorage);
        Controller controller = new Controller(kickstarter);
        View view = new ConsoleView(controller);

        in.add("h");

        view.run();

        assertThat(out.toString(), is("Hello! You are at Kickstarter.\r\n" +
                "\r\n" +
                "text1 (author1)\r\n" +
                "\r\n" +
                "Categories:\r\n" +
                "1. category1\r\n" +
                "\r\n" +
                "Please choose category number or enter \"h\" for help.\r\n" +
                "h\r\n" +
                "Help:\r\n" +
                "h - help\r\n" +
                "x or 0 - exit\r\n" +
                "c - list of categories\r\n" +
                "u - update\r\n" +
                "b - back\r\n" +
                "\r\n" +
                "Please make your choice (h/x/c/u/b).\r\n" +
                "\r\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(oldOut);
        System.setIn(oldIn);
    }
}