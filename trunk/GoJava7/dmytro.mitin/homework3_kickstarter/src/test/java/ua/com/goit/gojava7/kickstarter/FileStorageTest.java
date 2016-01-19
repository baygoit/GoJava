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
import ua.com.goit.gojava7.kickstarter.model.storage.FileCategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.FileQuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.util.ConsoleMock;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;
import ua.com.goit.gojava7.kickstarter.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileStorageTest {
    private final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private String quotePath = classLoader.getSystemResource("").getPath() + "/test-quotes";

    private String categoryPath = classLoader.getSystemResource("").getPath() + "/test-categories";

    private String projectPath = classLoader.getSystemResource("").getPath() + "/test-projects";

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
        in.add("h");

        QuoteStorage quoteStorage = new FileQuoteStorage(quotePath);
        Quote quote = new Quote("quote1", "author1");
        quoteStorage.add(quote);

        CategoryStorage categoryStorage = new FileCategoryStorage(categoryPath, projectPath);
        Category category = new Category("category1");
        categoryStorage.add(category);
        new Project("project1", category, "short description", "long description", "history...",
                "http://wwww.youtube.com/...", 100, 10);
        Kickstarter kickstarter = new Kickstarter(categoryStorage, quoteStorage);
        Controller controller = new Controller(kickstarter);
        View view = new ConsoleView(controller);
        view.run();

        assertThat(out.toString(), is("Hello! You are at Kickstarter.\r\n" +
                "\r\n" +
                "quote1 (author1)\r\n" +
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
    public void cleanUpStreamsFiles() {
        System.setOut(oldOut);
        System.setIn(oldIn);
        new File(quotePath).delete();
        new File(categoryPath).delete();
        new File(projectPath).delete();
    }
}
